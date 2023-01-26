package com.example.demo2.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericSortColumn {

    @JsonProperty("FieldName")
    private String fieldName;
    @JsonProperty("OrderDir")
    private String orderDir;


}
