package com.github.aevalo.utils;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import org.testng.annotations.Test;

public class TryTest {
  @Test(groups={"unit"})
  public void testSuccess() {
    try {
      int div = Try.with(() -> 10 / 5).get();
      assertThat(div).isEqualTo(2);
    }
    catch (Exception e) {
      fail("Normal division should not have failed.");
    }
  }

  @Test(groups={"unit"})
  public void testFailure() {
    try {
      int div = Try.with(() -> 10 / 0).get();
      fail("Exception expected due to division by zero");
    }
    catch (Exception e) {
      assertThat(e).isInstanceOf(ArithmeticException.class);
      assertThat(e).hasMessage("/ by zero");
    }
  }
}
