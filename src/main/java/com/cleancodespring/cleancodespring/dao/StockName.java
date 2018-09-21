package com.cleancodespring.cleancodespring.dao;

import org.springframework.util.StringUtils;

public class StockName extends ValueObject {

  private String value;

  public StockName(String value) {
    this.value = value;
    ValidateStockName();
  }

  private void ValidateStockName() {
    if (StringUtils.containsWhitespace(value)) {
      throw new IllegalArgumentException(
          String.format("%s: %s contains whitespace", getClass(), value));
    }
  }

  public String getValue() {
    return value;
  }
}
