package com.github.aevalo.utils;

public class Success<T> extends Try<T> {
  public Success(T value) { this.value = value; }

  @Override
  public boolean isSuccess() { return true; }

  @Override
  public boolean isFailure() { return false; }
}
