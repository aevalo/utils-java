package com.github.aevalo.utils;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {
  @Test(groups={"unit"})
  public void appHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
  }
}
