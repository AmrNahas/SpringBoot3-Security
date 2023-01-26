package com.example.demo2.cntrl;

import com.example.demo2.authModule.AuthRequest;
import com.example.demo2.authModule.JwtUtils;
import com.example.demo2.authModule.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/api/v1/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthCntrl {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getIdentificationNum(), authRequest.getPassword()));
        final UserDetails userDetails = userDao.findUserByIdentification(authRequest.getIdentificationNum());
        if (userDetails != null)
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails.getUsername()));
        return ResponseEntity.status(400).body("some Error Has Occurred");
    }
}
