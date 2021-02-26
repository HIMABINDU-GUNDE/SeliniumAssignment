package stepDefinations;

import io.cucumber.java.en.*;

public class FizzbuzzStepDefs {
    int value;
    int fizzDivider;
    int buzzDivider;
    @Given("^Provide input (.+) (.+) (.+)$")
    public void provide_input(int range, int fizzdivider, int buzzdivider) throws Throwable {
      value=range;
      fizzDivider=fizzdivider;
      buzzDivider=buzzdivider;

    }

    @Then("^Print Numbers With Replacing Fizz_buzz$")
    public void print_numbers_with_replacing_fizzbuzz() throws Throwable {
        System.out.println("PRINTING VALUES");
        for (int i = 1; i <= value; i++){
            if (i % fizzDivider == 0) {
                System.out.println((i % buzzDivider == 0) ? "fizzbuzz" : "fizz");
            }
                else System.out.println((i % buzzDivider == 0) ? "buzz" : i);
        }
    }

}