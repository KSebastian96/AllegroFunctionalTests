package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ThermometersSubcategoryPage {
    public ThermometersSubcategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='_9c44d_2H7Kt']")
    private List<WebElement> adsList;

    public List<WebElement> getAdsList() {
        return adsList;
    }
}
