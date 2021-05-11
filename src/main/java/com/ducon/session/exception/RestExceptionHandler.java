package com.ducon.session.exception;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(DuconAppApiException.class)
  public ResponseEntity<Object> handleException(DuconAppApiException ex) {
    return ResponseEntity.status(ex.getStatusCode())
        .body(new DucanExceptionResponse(ex.getStatusCode(),ex.getData()));
  }
}
