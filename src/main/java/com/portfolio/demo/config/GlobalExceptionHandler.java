package com.portfolio.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portfolio.demo.Models.ErrorResponseModel;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecursoNoEncontradoException.class)
	public ResponseEntity<ErrorResponseModel> manejarNoEncontrado(RecursoNoEncontradoException ex) {
	    ErrorResponseModel error = new ErrorResponseModel(404, "Recurso no encontrado", ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthFailedException.class)
	public ResponseEntity<ErrorResponseModel> manejarAuth(AuthFailedException ex) {
	    ErrorResponseModel error = new ErrorResponseModel(403, "Autenticación no realizada", ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
}