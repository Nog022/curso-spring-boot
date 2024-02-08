package io.github.Nog022.SpringBootExpert.apiRest.controller;

import io.github.Nog022.SpringBootExpert.apiRest.ApiErrors;
import io.github.Nog022.SpringBootExpert.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerRegraNegociosException(RegraNegocioException ex){
        return new ApiErrors(ex.getMessage());
    }
}
