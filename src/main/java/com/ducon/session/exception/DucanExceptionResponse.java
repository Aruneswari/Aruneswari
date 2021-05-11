package com.ducon.session.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DucanExceptionResponse {
  private int code;

  private String message;
}
