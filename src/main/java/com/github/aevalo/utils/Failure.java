package com.github.aevalo.utils;

public class Failure<T> extends Try<T> {
  public Failure(Exception exception) { this.exception = exception; }

  @Override
  public boolean isSuccess() { return false; }

  @Override
  public boolean isFailure() { return true; }
}
