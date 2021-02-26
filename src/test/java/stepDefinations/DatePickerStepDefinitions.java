package stepDefinations;

import PageObjects.DatePickerDemo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import resources.Base;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerStepDefinitions extends Base {
    public WebDriver driver;
    String userDate;
    LocalDate date;
    int userDay;
    String userMonthYear;
    DatePickerDemo d;
    @Given("^Provide date=\"([^\"]*)\" input_in_yyyy/MM/DD_format$")
    public void provide_datesomething_inputinyyyymmddformat(String strArg1) throws Throwable {
        System.out.println(strArg1);
        userDate=strArg1;
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        date= LocalDate.parse(userDate);
        userDay=date.getDayOfMonth();
        userMonthYear= String.valueOf(date.getMonth()).concat(" ").concat(String.valueOf(date.getYear()));
    }

    @When("^Validate userdate$")
    public void validate_userdate() throws Throwable {
        boolean day=date.isBefore(LocalDate.now());
        Assert.assertFalse(day);
    }

    @And("^Navigate to \"([^\"]*)\"$")
    public void navigate_to_something(String strArg1) throws Throwable {
        driver=initializeDriver();
        driver.get(strArg1);
    }

    @And("^Switch to iframe$")
    public void switch_to_iframe() throws Throwable {
        d=new DatePickerDemo(driver);
        driver.switchTo().frame(d.iframe());
        d.datePickerClick().click();

    }

    @And("^Select user month$")
    public void select_user_month() throws Throwable {
        while (true){
            if(d.title().getText().equalsIgnoreCase(userMonthYear))
                break;
            else d.navigateIcon().click();
        }
    }

    @And("^Select user date$")
    public void select_user_date() throws Throwable {
        int count=d.dates().size();
        for (int i=0;i<count;i++)
        {
            if(d.dates().get(i).getText().equalsIgnoreCase(String.valueOf(userDay))){
                d.dates().get(i).click();
            }
        }
    }
    @Then("^Close browser$")
    public void close_browser() throws Throwable {
        driver.close();
    }
}