package com.cleancodespring.cleancodespring.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StockValueObjectTest {

  /* Test naming conventions */

  // UnitOfWork_StateUnderTest_ExpectedBehavior
  // Give_When_Then
  // MethodName_StateUnderTest_ExpectedBehavior

  @Test
  public void Equals_TwoEquivalentObjects_IsTrue() {
    StockName stockName1 = new StockName("name");
    StockName stockName2 = new StockName("name");
    List<StockName> list = new ArrayList<StockName>() {{
      add(stockName1);
      add(stockName2);
    }};
    StockValueObject stockValueObject1 = new StockValueObject(stockName1, 1.00f, list);
    StockValueObject stockValueObject2 = new StockValueObject(stockName2, 1.00f, list);

    assertTrue(stockValueObject1.equals(stockValueObject2));
  }

  @Test
  public void Equals_TwoVarsReferencingOneObject_IsTrue() {
    StockName stockName1 = new StockName("name");
    List<StockName> list = new ArrayList<StockName>() {{
      add(stockName1);
      add(stockName1);
    }};
    StockValueObject stockValueObject1 = new StockValueObject(stockName1, 1.00f, list);
    StockValueObject stockValueObject2 = stockValueObject1;

    assertTrue(stockValueObject1.equals(stockValueObject2));
  }

  @Test
  public void Equals_TwoDifferentObjects_IsFalse() {
    StockName stockName1 = new StockName("name1");
    StockName stockName2 = new StockName("name2");
    List<StockName> list = new ArrayList<StockName>() {{
      add(stockName1);
      add(stockName1);
    }};
    StockValueObject stockValueObject1 = new StockValueObject(stockName1, 1.00f, list);
    StockValueObject stockValueObject2 = new StockValueObject(stockName2, 1.00f, list);

    assertFalse(stockValueObject1.equals(stockValueObject2));
  }

  @Test
  public void Equals_DifferentStockPrices_IsFalse() {
    StockName stockName1 = new StockName("name");
    StockName stockName2 = new StockName("name");
    List<StockName> list = new ArrayList<StockName>() {{
      add(stockName1);
      add(stockName2);
    }};
    StockValueObject stockValueObject1 = new StockValueObject(stockName1, 1.00f, list);
    StockValueObject stockValueObject2 = new StockValueObject(stockName2, 1.01f, list);

    assertFalse(stockValueObject1.equals(stockValueObject2));
  }

  @Test
  public void Equals_DifferentDetailsList_IsFalse() {
    StockName stockName1 = new StockName("name1");
    StockName stockName2 = new StockName("name1");
    StockName stockName3 = new StockName("name32");
    List<StockName> list1 = new ArrayList<StockName>() {{
      add(stockName1);
      add(stockName1);
    }};
    List<StockName> list2 = new ArrayList<StockName>() {{
      add(stockName1);
      add(stockName3);
    }};
    StockValueObject stockValueObject1 = new StockValueObject(stockName1, 1.00f, list1);
    StockValueObject stockValueObject2 = new StockValueObject(stockName2, 1.00f, list2);

    assertFalse(stockValueObject1.equals(stockValueObject2));
  }

  @Test
  public void Equals_SecondStockIsNull_IsFalse() {
    StockName stockName = new StockName("name");

    List<StockName> list = new ArrayList<StockName>() {{
      add(stockName);
      add(stockName);
    }};

    StockValueObject stockValueObject1 = new StockValueObject(stockName, 1.00f, list);
    StockValueObject stockValueObject2 = null;

    assertFalse(stockValueObject1.equals(stockValueObject2));
  }
}