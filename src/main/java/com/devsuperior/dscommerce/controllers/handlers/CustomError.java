package com.devsuperior.dscommerce.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;

}
