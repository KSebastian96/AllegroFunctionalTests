package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "day")
    private WebElement dayOfBirth;
    @FindBy(xpath = "//select[@name='month']")
    private WebElement monthOfBirth;
    @FindBy(id = "year")
    private WebElement yearOfBirth;
    @FindBy(css = ".m-label.ng-scope")
    private WebElement acceptTermsOfUseCheckbox;
    @FindBy(xpath = "//button[@ng-disabled='RegistrationCtrl.loading']")
    private WebElement createAccountButton;

    public void ClickCreateAccountButton(){
        createAccountButton.click();
    }

    public void AcceptTermsOfUse(){
        acceptTermsOfUseCheckbox.click();
    }

    public void FillYearOfBirth(String year){
        yearOfBirth.click();
        yearOfBirth.sendKeys(year);
    }

    public void FillMonthOfBirth(String month){
        monthOfBirth.click();
        monthOfBirth.sendKeys(month);
    }
    public void FillDayOfBirth(String day){
        dayOfBirth.click();
        dayOfBirth.sendKeys(day);
    }
    public void FillPasswordField(String password){
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void FillEmailField(String text){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(text);
    }
}
