package com.sparks.service.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceResponse<T> {

    private T data;
    private String errorMessage;

    public ServiceResponse(T data, String errorMessage) {
        this.data = data;
        this.errorMessage = errorMessage;
    }

}
