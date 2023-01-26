package com.example.demo2.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationRespInfo {
    @JsonProperty("NumberOfRecords")
    private Long numberOfRecords; // all records num in DB
    @JsonProperty("PageIndex")
    private int pageIndex;  //  offset
    @JsonProperty("PageSize")
    private int pageSize;  // limit
}
