package com.cleancodespring.cleancodespring.dao;

import java.util.ArrayList;
import java.util.List;

public final class StockValueObject extends ValueObject {

  private StockName stockName;
  private float stockPrice;
  private List<StockName> details;

  public StockValueObject(StockName stockName, float stockPrice,
      List<StockName> details) {
    this.stockName = stockName;
    this.stockPrice = stockPrice;
    this.details = details;
  }

  protected Iterable<Object> GetEqualityComponents() {
    return new ArrayList<Object>() {{
      add(stockName);
      add(stockPrice);
      add(details);
    }};
  }

  public StockName getStockName() {
    return stockName;
  }

  public float getStockPrice() {
    return stockPrice;
  }

  public List<StockName> getDetails() {
    return details;
  }
}
