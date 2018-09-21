package com.cleancodespring.cleancodespring.dao;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class StockNameTest {

  @Test(expected = IllegalArgumentException.class)
  public void StockName_StockNameHasWhitespace_ThrowsException() {
    new StockName("hello world");
  }

  @Test
  public void StockName_TwoEquivalentStockNames_IsTrue() {
    StockName stockName1 = new StockName("MyStock");
    StockName stockName2 = new StockName("MyStock");

    assertTrue(stockName1.equals(stockName2));
  }
}