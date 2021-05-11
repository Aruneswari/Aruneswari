package com.ducon.session.exception;

import lombok.Data;

@Data
public class DuconAppApiException extends Exception {

  private static final long serialVersionUID = -7558618748640066498L;
  private int statusCode;
  private String data;

  public DuconAppApiException(String data, int statusCode) {
    this.data = data;
    this.statusCode = statusCode;
  }
}
