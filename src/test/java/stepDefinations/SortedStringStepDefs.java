package stepDefinations;

import io.cucumber.java.en.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedStringStepDefs {
    String lowerCaseInput;
    String outputString;
    @Given("^Provide inputstring (.+) And Covert To LowerCase$")
    public void provide_inputstring_and_covert_to_lowercase(String input) throws Throwable {
       lowerCaseInput=input.toLowerCase();
       System.out.println("Given input string: "+lowerCaseInput);
    }

    @When("^Sort and Remove Duplicates$")
    public void sort_and_remove_duplicates() throws Throwable {
        outputString= Stream.of(lowerCaseInput.split("")).sorted().distinct().collect(Collectors.joining());
    }

    @Then("^Print SortedString$")
    public void print_sortedstring() throws Throwable {
        System.out.println("Sorted string: "+outputString);
    }

}
