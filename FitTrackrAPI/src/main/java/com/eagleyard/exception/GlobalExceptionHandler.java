package com.eagleyard.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandler(NoHandlerFoundException ex, WebRequest wr) {
	    log.warn("NoHandlerFoundException: " + ex.getMessage(), ex);
	    return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> parentException(Exception ex, WebRequest wr) {
	    log.warn("Exception: " + ex.getMessage(), ex);
	    return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgValidException(MethodArgumentNotValidException ex, WebRequest wr) {
	    log.warn("MethodArgumentNotValidException: " + ex.getMessage(), ex);
	    return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(GymException.class)
	public ResponseEntity<ErrorDetails> gymException(GymException ex, WebRequest wr) {
	    log.warn("GymException: " + ex.getMessage(), ex);
	    return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}

}
