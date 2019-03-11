package com.github.aevalo.utils.examples;

import com.github.aevalo.utils.Try;
import java.util.Optional;
import java.util.Scanner;

public class TryApp
{
  public static void main(String [] args) {
    Try<Integer> problem = Try.with(() -> {
      Scanner sc = new Scanner(System.in);
      System.out.print("Input dividend: ");
      Integer dividend = Integer.valueOf(sc.nextLine()).intValue();
      System.out.print("Input divisor: ");
      Integer divisor = Integer.valueOf(sc.nextLine()).intValue();
      return Integer.valueOf(dividend / divisor);
    });
    if (problem.isSuccess()) {
      int result = problem.asOptional().get().intValue();
      System.out.println(String.format("Result is %d", result));
    } else {
      System.err.println("Failure due to exception");
    }
  }
}
