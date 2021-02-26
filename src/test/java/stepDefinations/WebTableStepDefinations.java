package stepDefinations;

import PageObjects.TableValuesDemo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import resources.Base;
import java.io.IOException;

public class WebTableStepDefinations extends Base {
    public WebDriver driver;
    TableValuesDemo t;

    @Given("Navigate to url {string}")
    public void navigateToUrl(String arg0) throws IOException {
        driver=initializeDriver();
        driver.get(arg0);
    }

    @When("Retrieve Header values")
    public void retrieveHeaderValues() {
        t=new TableValuesDemo(driver);
        System.out.println("Header values:");
        for (int id = 0; id < t.columHeader().size(); id++) {
            String header = t.columHeader().get(id).getText();
            System.out.printf("%-35s", header);
        }
        System.out.println("");
        System.out.println("..................................................................................");

    }
    @And("Retrieve each row values")
    public void retrieveEachRowValues() {
     t.rowData();
    }

    @Then("Quit the browser")
    public void quitTheBrowser() {
        driver.quit();
    }
}
