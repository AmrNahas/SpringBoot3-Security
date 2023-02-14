package com.example.demo.common.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;

@Getter
@Setter
@AllArgsConstructor
public class GenericStatusResp {
    public static long VALID_CODE=0;
    public static String VALID_MSG= "Success";
    @JsonProperty("ResponseCode")
    public long responseCode;
    @JsonProperty("ResponseDescLa")
    public String responseDescLa;
    @JsonProperty("ResponseDescAr")
    public String responseDescAr;
    @JsonProperty("REQUEST-UUID")
    public String requestUUID;


    public GenericStatusResp() {
        this.responseCode = VALID_CODE;
        this.responseDescLa = VALID_MSG;
        this.responseDescAr = VALID_MSG;
        try {
            this.requestUUID = MDC.get("REQUEST-UUID");
            MDC.put("RESP_CODE",String.valueOf(responseCode));
            MDC.put("Response_Desc_La",responseDescLa);
            MDC.put("Response_Desc_Ar",responseDescAr);
        } catch (Exception e) {
            this.requestUUID=null;
        }
    }



    public GenericStatusResp(long responseCode, String responseDescLa, String responseDescAr) {
        this.responseCode = responseCode;
        this.responseDescLa = responseDescLa;
        this.responseDescAr = responseDescAr;
        try {
            this.requestUUID = MDC.get("REQUEST-UUID");
            MDC.put("RESP_CODE",String.valueOf(responseCode));
            MDC.put("Response_Desc_La",responseDescLa);
            MDC.put("Response_Desc_Ar",responseDescAr);
        } catch (Exception e) {
            this.requestUUID=null;
        }

    }


}
