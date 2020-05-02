package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page_object.LoginPage;
import page_object.LoginPasswordPage;
import page_object.MainPage;
import page_object.MyAccountPage;

public class ChangingPasswordSteps extends Base_Step {
    String password = "*******";
    String newPassword = "********";

    @Given("User is logged in")
    public void userIsLoggedIn() {
        driver.get("https://allegro.pl/login/form?authorization_uri=https:%2F%2Fallegro.pl%2Fauth%2Foauth%2Fauthorize%3Fclient_id%3Dtb5SFf3cRxEyspDN%26redirect_uri%3Dhttps:%2F%2Fallegro.pl%2Flogin%2Fauth%3Forigin_url%253D%25252F%25253Flogout%25253D1%26response_type%3Dcode%26state%3D6UjELJ&oauth=true");
        new MainPage(driver).AcceptCookies();
        new LoginPage(driver).FillUsernameField("*******");
        new LoginPage(driver).FillPasswordField(password);
        new LoginPage(driver).ClickLoginButton();
    }

    @When("User click my account button")
    public void userClickMyAccountButton() throws InterruptedException {
        Thread.sleep(2000);
        new MainPage(driver).UserDropdownClick();
        new MainPage(driver).ClickMyAccountButton();

    }

    @And("User click login and password button")
    public void userClickLoginAndPasswordButton() {
        new MyAccountPage(driver).ClickLoginAndPasswordButton();
    }

    @And("User click change password button")
    public void userClickChangePasswordButton() {
        new LoginPasswordPage(driver).ClickChangePasswordButton();
    }

    @And("User enter actual password incorrectly")
    public void userEnterActualPasswordIncorrectly() {
        new LoginPasswordPage(driver).FillActualPasswordField("password");
    }

    @And("User enter new password")
    public void userEnterNewPassword() {
        new LoginPasswordPage(driver).FillNewPasswordField(newPassword);
    }

    @And("User confirm new password")
    public void userConfirmNewPassword() {
        new LoginPasswordPage(driver).FillConfirmNewPasswordField(newPassword);
    }

    @And("User click change button")
    public void userClickChangeButton() {
        new LoginPasswordPage(driver).ClickChangeButton();
    }

    @Then("Error message appeared")
    public void errorMessageAppeared() throws InterruptedException {
        Thread.sleep(500);
        String errorMessage = new LoginPasswordPage(driver).getErrorMessage();
        Assert.assertEquals("Aktualne hasło jest nieprawidłowe.", errorMessage);
    }

    @And("User quit the browser")
    public void userQuitTheBrowser() {
        driver.quit();
    }


    @And("User enter actual password correctly")
    public void userEnterActualPasswordCorrectly() {
        new LoginPasswordPage(driver).FillActualPasswordField(password);
    }

    @Then("Success message appeared")
    public void successMessageAppeared() {
        String successMessage = new LoginPasswordPage(driver).getSuccessMessage();
        Assert.assertEquals("Twoje hasło zostało zmienione. Za chwilę zostaniesz wylogowany... 5", successMessage);
    }


}
