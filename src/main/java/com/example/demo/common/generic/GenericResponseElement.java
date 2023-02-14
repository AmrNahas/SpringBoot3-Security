package com.example.demo.common.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericResponseElement<T> {

  @JsonProperty("Data")
  public  T responseData;

 // @JsonProperty("Status")
  @JsonUnwrapped // to remove root
  public GenericStatusResp respStatus;


  public GenericResponseElement(T responseData) {
    this.responseData = responseData;
    this.respStatus = new GenericStatusResp();
  }
}
