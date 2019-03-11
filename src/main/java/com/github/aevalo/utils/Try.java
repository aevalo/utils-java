package com.github.aevalo.utils;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * The `Try` class is used to perform an operation, which may throw an exceptio,
 * or return value. Resulting instance is either of type
 * [[com.github.aevalo.utils.Success]][T] or [[com.github.aevalo.utils.Failure]][T].
 * API is based ont Scala Try utility class, and ported to Java 8 by author.
 *
 * For example, `Try` can be used to perform division on a user-defined input,
 * without the need to do explicit exception-handling in all of the places that
 * an exception might occur.
 *
 * Example:
 * {{{
 *  import com.github.aevalo.utils.Try;
 *  import java.util.Optional;
 *  import java.util.Scanner;
 *
 *  Try<Integer> problem = Try.with(() -> {
 *    Scanner sc = new Scanner(System.in);
 *    System.out.print("Input dividend: ");
 *    Integer dividend = Integer.valueOf(sc.nextLine()).intValue();
 *    System.out.print("Input divisor: ");
 *    Integer divisor = Integer.valueOf(sc.nextLine()).intValue();
 *    return Integer.valueOf(dividend / divisor);
 *  });
 * }}}
 *
 * @author Arttu Valo
 * @since 0.1.0
 */
public abstract class Try<T> {
  protected T value = null;
  protected Exception exception = null;

  abstract public boolean isSuccess();
  abstract public boolean isFailure();

  /**
   * Returns the value resulted from Try.with() call, or throws an exception.
   * Functionality depends on instantiated class.
   *
   * @return      the image at the specified URL
   * @throws      the exeption caught in Try#with()
   */
 public T get() throws Exception {
    if (isSuccess()) { return value; }
    throw exception;
  }

  /**
   * Returns the value resulted from Try.with() as Optional.
   *
   * @return      the image at the specified URL
   * @see         java.util.Optional
   */
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

  /**
   * Creates instance of Success or Failure, depending on parameter.
   * Functionality depends on instantiated class.
   *
   * @param       Lambda function supplying the value of returned instance
   * @return      Instance of Success or Failure
   */
  public static <T> Try<T> with(Supplier<T> supplier) {
    try { return new Success<>(supplier.get()); }
    catch (Exception e) { return new Failure<>(e); }
  }
}
