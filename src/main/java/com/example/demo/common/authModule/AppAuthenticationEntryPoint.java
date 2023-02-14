package com.example.demo.common.authModule;

import com.example.demo.common.generic.GenericResponseElement;
import com.example.demo.common.generic.GenericResponseRoot;
import com.example.demo.common.generic.GenericStatusResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;


@Component
public class AppAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final Logger log = LoggerFactory.getLogger(AppAuthenticationEntryPoint.class);

    @Override
    public final void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException e) throws IOException {
        GenericResponseRoot<Object> resp = new GenericResponseRoot<>(new GenericResponseElement<>(null, new GenericStatusResp(AuthConstants.ERR_DESC_NOT_AUTH_NUM, AuthConstants.ERR_DESC_AR, AuthConstants.ERR_DESC_LA)));
        e.printStackTrace();
        log.info(" AppAuthenticationEntryPoint :{} : {}", "401", e.getMessage());
        response.setStatus(HttpStatus.OK.value());
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //  response.getWriter().write(mapper.writeValueAsString(new AuthErrorResponse( new BusinessErrorDescDto()))); //  ... errorDescSrvc.getErrorDescDtoForAuth()
        response.getWriter().write(mapper.writeValueAsString(resp));

    }


}
