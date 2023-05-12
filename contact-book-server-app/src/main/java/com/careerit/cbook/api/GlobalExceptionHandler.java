package com.careerit.cbook.api;

import com.careerit.cbook.dto.ApiError;
import com.careerit.cbook.service.exception.ContactException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {ContactException.class})
  public ResponseEntity<ApiError> handleContactException(RuntimeException ex, WebRequest request) {
    ApiError apiError = ApiError.builder()
        .message(ex.getMessage())
        .status(HttpStatus.BAD_REQUEST.value())
        .path(((ServletWebRequest) request).getRequest().getRequestURI().toString())
        .timestamp(LocalDateTime.now())
        .build();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
  }

  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ResponseEntity<ApiError> handleConflicts(RuntimeException ex, WebRequest request) {
    ApiError apiError = ApiError.builder()
        .message(ex.getMessage())
        .status(HttpStatus.BAD_REQUEST.value())
        .path(((ServletWebRequest) request).getRequest().getRequestURI().toString())
        .timestamp(LocalDateTime.now())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
  }


}
