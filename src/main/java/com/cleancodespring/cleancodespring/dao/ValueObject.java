package com.cleancodespring.cleancodespring.dao;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ValueObject {

  protected Iterable<Object> GetEqualityComponents() {
    List<Object> list = new ArrayList<>();

    for (Field f : getClass().getDeclaredFields()) {
      try {
        f.setAccessible(true);
        list.add(f.get(this));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      throw new IllegalArgumentException(String
          .format("Invalid comparison of Value Objects of different types: %s and %s",
              this.getClass(), object.getClass()));
    }

    ValueObject valueObject = (ValueObject) object;
    return GetEqualityComponents().equals(valueObject.GetEqualityComponents());
  }

  public int hashCode() {
    return Objects.hash(GetEqualityComponents());
  }

  // TODO: Figure out a way to get the variable names and associate them with their
  // corresponding values
  public String toString() {
    final ToStringHelper helper = MoreObjects.toStringHelper(this);

    for (Object o : GetEqualityComponents()) {
      helper.add("value", o.toString());
    }
    return helper.toString();
  }
}
