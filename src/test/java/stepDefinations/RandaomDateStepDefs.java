package stepDefinations;

import PageObjects.RandomDate;
import io.cucumber.java.en.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class RandaomDateStepDefs extends RandomDate {
    int week;
    int days;
    LocalDate randomDate;
    LocalDate randomWorkingDate;
    long start;
    long end;
    @Given("^Provide (.+) and convert to days$")
    public void provide_and_convert_to_days(int weekRange) throws Throwable {
       week=weekRange;
       days= week*7;
    }
    @When("^Generate random date$")
    public void generate_random_date() throws Throwable {
        LocalDate startDate = LocalDate.now();
        start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now().plusDays(days);
        end = endDate.toEpochDay();
    }

    @And("^Validate random date$")
    public void validate_random_date() throws Throwable {
        RandomDate r=new RandomDate();
        while (true) {
            randomDate =r.generateRandomDate(start,end);
            DayOfWeek day = randomDate.getDayOfWeek();
            if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY && !randomDate.equals(LocalDate.now())) {
                randomWorkingDate=randomDate;
                break;
            }
        }
    }

    @Then("^Print randomdate$")
    public void print_randomdate() throws Throwable {
        System.out.println("Random Working day: "+randomWorkingDate);
    }
}
