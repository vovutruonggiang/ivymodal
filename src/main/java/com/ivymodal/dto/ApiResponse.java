package com.ivymodal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>{
    private int code = 1000;
    private String message;
    private T result;
}
