package com.example.demo2.authModule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.MDC;

@NoArgsConstructor
@Getter
@Setter
public class AuthErrorResponse {
    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("ResponseDescLa")
    private String responseDescLa;
    @JsonProperty("ResponseDescAr")
    private String responseDescAr;
    @JsonProperty("REQUEST-UUID")
    private String requestUUID;





    public AuthErrorResponse(BusinessErrorDescDto errorDescDto) {
        this.responseDescAr = errorDescDto != null && errorDescDto.getResponseDescAr() != null ? errorDescDto.getResponseDescAr() : AuthConstants.ERR_DESC_AR;
        this.responseDescLa =  errorDescDto != null && errorDescDto.getResponseDescLa() != null ? errorDescDto.getResponseDescLa() : AuthConstants.ERR_DESC_LA;
        this.responseCode =errorDescDto != null && errorDescDto.getResponseCode()!=null ? String.valueOf(errorDescDto.getResponseCode()):AuthConstants.ERR_DESC_NOT_AUTH;
        requestUUID= MDC.get("REQUEST-UUID");
    }



}
