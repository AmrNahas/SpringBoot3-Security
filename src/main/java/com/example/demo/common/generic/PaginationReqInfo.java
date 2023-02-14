package com.example.demo.common.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaginationReqInfo {
    @JsonProperty("PageIndex")
    private Integer pageIndex;  //  offset
    @JsonProperty("PageSize")
    private Integer pageSize;  // limit
    @JsonProperty("SortCriteria")
    private List<GenericSortColumn> sortColumns;  // the sort sortCriteria
}
