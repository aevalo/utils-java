package com.github.aevalo.utils;

import java.util.Optional;
import java.util.function.Supplier;

public abstract class Try<T> {
  protected T value = null;
  protected Exception exception = null;

  abstract public boolean isSuccess();
  abstract public boolean isFailure();

  public T get() throws Exception {
    if (isSuccess()) { return value; }
    throw exception;
  }

  public Optional<T> asOptional() {
    Optional<T> ret;
    try {
      if (isSuccess()) ret = Optional.ofNullable(get());
      else ret = Optional.empty();
    }
    catch (Exception e) {
      ret = Optional.empty();
    }
    return ret;
  }

  public static <T> Try<T> with(Supplier<T> supplier) {
    try { return new Success<>(supplier.get()); }
    catch (Exception e) { return new Failure<>(e); }
  }
}
