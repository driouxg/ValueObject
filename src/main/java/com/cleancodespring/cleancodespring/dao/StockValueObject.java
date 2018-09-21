package com.cleancodespring.cleancodespring.dao;

import java.util.List;

public class StockValueObject extends ValueObject {

  private StockName stockName;
  private float stockPrice;
  private List<StockName> details;

  public StockValueObject(StockName stockName, float stockPrice,
      List<StockName> details) {
    this.stockName = stockName;
    this.stockPrice = stockPrice;
    this.details = details;
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
