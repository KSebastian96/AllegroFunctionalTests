package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPasswordPage {
    public LoginPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-testid='changePasswordLink']")
    private WebElement changePasswordButton;
    @FindBy(id = "oldPassword")
    private WebElement actualPasswordField;
    @FindBy(id = "newPassword")
    private WebElement newPasswordField;
    @FindBy(id = "confirmedNewPassword")
    private WebElement confirmNewPasswordField;
    @FindBy(xpath = "//button[@data-testid='modalButtonConfirm']")
    private WebElement changeButton;
    @FindBy(xpath = "//div[@class='_6x7yn _1nwmc']")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@data-testid='message-paragraph']")
    private WebElement successMessage;

    public String getSuccessMessage(){
        return successMessage.getText();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void ClickChangeButton(){
        changeButton.click();
    }

    public void FillConfirmNewPasswordField(String newPassword){
        confirmNewPasswordField.sendKeys(newPassword);
    }

    public void FillNewPasswordField(String newPassword){
        newPasswordField.sendKeys(newPassword);
    }

    public void FillActualPasswordField(String password){
        actualPasswordField.sendKeys(password);
    }
    public void ClickChangePasswordButton(){
        changePasswordButton.click();
    }
}
