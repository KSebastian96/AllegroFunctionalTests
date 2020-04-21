package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FashionCategoryPage {


    public FashionCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/dzial/moda/on']")
    private List<WebElement> onSubcategoryButtons;

    public void ClickOnSubcategoryButton() {
        onSubcategoryButtons.get(1).click();
    }
}
