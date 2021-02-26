package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableValuesDemo {
    public static WebDriver driver;

    private By rows=By.xpath("//div[@class='w3-example']/div/table/tbody/tr");
    private By columns=By.xpath("//table[@id='customers']/tbody/tr[1]/th");
    private By columnHeader=By.xpath("//div[@class='w3-example']/div/table/tbody/tr/th");

    public TableValuesDemo(WebDriver driver) { this.driver=driver; }

    public int rows()
    {
        return driver.findElements(rows).size();
    }
    public int columns()
    {
        return driver.findElements(columns).size();
    }
    public List<WebElement> columHeader()
    {
        return driver.findElements(columnHeader);
    }

    public void rowData() {
        for(int index = 2; index <= rows(); index++) {
            for (int secondIndex = 1; secondIndex <= columns(); secondIndex++) {
                By table=By.xpath("//table[@id='customers']/tbody/tr["+index+"]/td["+secondIndex+"]");
                String Table_data=driver.findElement(table).getText();
                System.out.printf("%-35s", Table_data);
            }
            System.out.println("");
        }
    }
}
