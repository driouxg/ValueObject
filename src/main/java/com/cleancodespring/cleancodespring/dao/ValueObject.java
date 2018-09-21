package com.cleancodespring.cleancodespring.dao;

import java.util.Objects;

public abstract class ValueObject {

  protected abstract Iterable<Object> GetEqualityComponents();

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

  @Override
  public int hashCode() {
    return Objects.hash(GetEqualityComponents());
  }
}
