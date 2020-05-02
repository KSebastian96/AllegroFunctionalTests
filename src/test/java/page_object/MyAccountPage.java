package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='p1ge4'] //a[@href='/moje-allegro/moje-konto/logowanie-i-haslo']")
    private WebElement loginAndPasswordButton;

    public void ClickLoginAndPasswordButton(){
        loginAndPasswordButton.click();
    }
}
