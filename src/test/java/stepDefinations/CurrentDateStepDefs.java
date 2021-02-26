package stepDefinations;

import io.cucumber.java.en.*;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class CurrentDateStepDefs {
    LocalDate date;
    DayOfWeek day;
    @Given("^Get current date$")
    public void get_current_date() throws Throwable {
      date=LocalDate.now();
    }

    @When("^Get current day of week$")
    public void get_current_day_of_week() throws Throwable {
        day=date.getDayOfWeek();
    }

    @Then("^Validate current day$")
    public void validate_current_day() throws Throwable {
        if (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)) {
            System.out.println("Today is non working day!"); }
        else System.out.println("Today is a working day!");

    }


}
