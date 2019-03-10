package gradle.cucumber;

import com.github.aevalo.utils.Try;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import java.util.Optional;
import static org.fest.assertions.api.Assertions.assertThat;

public class Stepdefs {
  private int divisor;
  private String actualAnswer;

  @Given("^divisor is \"([^\"]*)\"$")
  public void divisor_is(String divisor) {
    this.divisor = Integer.parseInt(divisor);
  }

  @When("^I ask the value of division$")
  public void i_ask_the_value_of_division() {
    Optional<Integer> maybeValue = Try.with(() -> 10 / divisor).asOptional();
    actualAnswer = maybeValue.map(
      (value) -> String.valueOf(value.intValue()))
      .orElse("None");
  }

  @Then("^I should be told \"([^\"]*)\"$")
  public void i_should_be_told(String expectedAnswer) {
    assertThat(expectedAnswer).isEqualTo(actualAnswer);
  }
}
