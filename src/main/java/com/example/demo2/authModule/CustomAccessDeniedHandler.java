package com.example.demo2.authModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exc) throws IOException, ServletException {
        log.error(" CustomAccessDeniedHandler : {} ,{}", "403 Forbidden", " Access Not Allowed ...");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
        // response.getWriter().write(mapper.writeValueAsString(new AuthErrorResponse("Access Not Allowed ...", "403")));
        response.getWriter().write(mapper.writeValueAsString(new AuthErrorResponse(new BusinessErrorDescDto(403L, "Access Not Allowed ...", "Access Not Allowed ..."))));

    }
}
