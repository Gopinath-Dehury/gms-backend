package com.dailycodework.sbr_demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID=1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName,Object fieldValue) {
        super(String.format("%s not found with %s:%s",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
