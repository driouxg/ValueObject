package com.cleancodespring.cleancodespring.dao;

import java.util.ArrayList;
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

  protected Iterable<Object> GetEqualityComponents() {
    return new ArrayList<Object>() {{
      add(value);
    }};
  }

  public String getValue() {
    return value;
  }
}
