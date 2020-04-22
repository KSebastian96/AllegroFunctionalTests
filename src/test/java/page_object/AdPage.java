package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdPage {
    public AdPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-button']")
    private WebElement addToCartButton;
    @FindBy(css = "._6f16n._14uqc._1r8rh._9a071_2cOcY")
    private WebElement amountField;
    @FindBy(css = "._1svub._lf05o._9a071_2MEB_")
    private WebElement adPrice;
    @FindBy(xpath = "//a[@href='/koszyk']")
    private List<WebElement> cartButtons;

    public void ClickProceedToCartButton(){
        cartButtons.get(1).click();
    }

    public void ClickAddToCartButton(){
        addToCartButton.click();
    }

    public String getAdPrice() {
        String adPriceString = adPrice.getText();
        return adPriceString;
    }

    public void FillAmountField(String amount) {
        amountField.click();
        amountField.clear();
        amountField.sendKeys(amount);
    }
}
