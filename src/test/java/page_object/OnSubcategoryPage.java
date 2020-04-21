package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnSubcategoryPage {
    public OnSubcategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-box-id='4XwVqWqxTXm1ZWUdqMTTEA=='] //li[@class='_1bmp9 _1tq4i _1fwkl  ']")
    private List<WebElement> subcategoryButtonList;

    public void ClickWatchesSubcategory() {
        subcategoryButtonList.get(4).click();
    }
}


