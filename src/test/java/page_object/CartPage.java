package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//price[@type='primary']")
    private List<WebElement> priceList;
    @FindBy(css = "._1vryf._26954_3_5IX ")
    private WebElement pricePerUnit;

    public String getPricePerUnit(){
        String pricePerUnitString = pricePerUnit.getText();
        return pricePerUnitString;
    }

    public String getTotalPrice(){
        String totalPrice = priceList.get(0).getText();
        return totalPrice;
    }
}
