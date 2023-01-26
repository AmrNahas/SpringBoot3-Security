package com.example.demo2.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class GenericRequestRoot<T>  {
    @JsonProperty("Request")
    @NotNull
    @Valid
    public T requestObj;

}
