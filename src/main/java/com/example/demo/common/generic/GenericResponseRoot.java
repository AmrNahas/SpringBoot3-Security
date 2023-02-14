package com.example.demo.common.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseRoot<T>{
  @JsonProperty("Response")
  public GenericResponseElement<T> responseObject;


}
