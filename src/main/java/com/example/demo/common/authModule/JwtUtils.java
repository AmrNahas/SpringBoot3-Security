package com.example.demo.common.authModule;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {


    public static final long JWT_TOKEN_VALIDITY = AuthConstants.ACCESS_TOKEN_VALIDITY_SECONDS;

    @Value(AuthConstants.SIGNING_KEY)
    private String secret;

    // retrieve username from jwt token
    public String getIdentificationNumFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody();
    }

    // check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // get Date of expiration for token
    public Long getTokenExpiredTime(String token) {
        return getExpirationDateFromToken(token).getTime();

    }

    public Date getTokenExpiredDate(String token) {
        return getExpirationDateFromToken(token);

    }


    // generate token for user
    public String generateToken(String identificationNum) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, identificationNum);
    }

    // while creating the token -
    // 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
    // 2. Sign the JWT using the HS512 algorithm and secret key.
    // 3. According to JWS Compact
    // compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    // validate token
    public Boolean validateToken(String token, String userName) {
        final String username = getIdentificationNumFromToken(token);
        return (username.equals(userName) && !isTokenExpired(token));
    }
}

