package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "wrong-password-error-title")
    private WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void FillUsernameField(String username) {
        usernameInput.sendKeys(username);
    }

    public void FillPasswordField(String password) {
        passwordInput.sendKeys(password);
    }

    public void ClickLoginButton() {
        loginButton.click();
    }
}
