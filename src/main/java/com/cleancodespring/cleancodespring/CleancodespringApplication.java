package com.cleancodespring.cleancodespring;

import com.cleancodespring.cleancodespring.dao.StockName;
import com.cleancodespring.cleancodespring.dao.StockValueObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CleancodespringApplication {

  public static void main(String[] args) {
    SpringApplication.run(CleancodespringApplication.class, args);

    StockName stockName = new StockName("Hello");
    StockName stockName1 = new StockName("How");
    System.out.println(stockName);

    List<StockName> list = new ArrayList<StockName>(){{
      add(stockName);
      add(stockName1);
    }};

    StockValueObject stockValueObject = new StockValueObject(stockName, 1.01f, list);
    StockValueObject stockValueObject1 = new StockValueObject(stockName1, 1.00f, list);

    System.out.println(stockValueObject);
  }
}
