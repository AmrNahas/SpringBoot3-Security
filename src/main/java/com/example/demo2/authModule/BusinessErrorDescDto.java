package com.example.demo2.authModule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessErrorDescDto {
    private Long responseCode;
    private String responseDescAr;
    private String responseDescLa;
}
