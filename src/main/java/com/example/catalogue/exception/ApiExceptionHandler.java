// ApiExceptionHandler.java
package com.example.catalogue.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.time.Instant;
import java.util.*;

@ControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> nf(NotFoundException ex){ return body(HttpStatus.NOT_FOUND, ex.getMessage()); }
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<?> br(BadRequestException ex){ return body(HttpStatus.BAD_REQUEST, ex.getMessage()); }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> val(MethodArgumentNotValidException ex){
    String msg = ex.getBindingResult().getFieldErrors().stream()
      .map(e->e.getField()+": "+e.getDefaultMessage()).findFirst().orElse("Validation error");
    return body(HttpStatus.BAD_REQUEST, msg);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> other(Exception ex){ return body(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()); }

  private ResponseEntity<Map<String,Object>> body(HttpStatus st, String msg){
    Map<String,Object> m=new HashMap<>();
    m.put("timestamp", Instant.now().toString());
    m.put("status", st.value()); m.put("error", st.getReasonPhrase()); m.put("message", msg);
    return ResponseEntity.status(st).body(m);
  }
}