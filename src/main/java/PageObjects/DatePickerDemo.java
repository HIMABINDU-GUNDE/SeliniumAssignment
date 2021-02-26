package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerDemo {
    public static WebDriver driver;

    public DatePickerDemo(WebDriver driver) {
        this.driver=driver;
    }

    private By iframe=By.xpath("//*[@id='content']/iframe");
    private By datePicker=By.className("hasDatepicker");
    private By title=By.cssSelector(".ui-datepicker-title");
    private By navigateicon=By.xpath("//div[@id='ui-datepicker-div']/div/a[2]");
    private By dates=By.xpath("//td[@data-handler='selectDay']");

    public WebElement iframe() { return  driver.findElement(iframe); }
    public WebElement datePickerClick() { return driver.findElement(datePicker); }
    public WebElement title() { return  driver.findElement(title); }
    public WebElement navigateIcon() { return  driver.findElement(navigateicon); }
    public List<WebElement> dates() { return driver.findElements(dates); }


}
