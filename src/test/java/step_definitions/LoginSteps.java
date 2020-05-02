package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page_object.LoginPage;
import page_object.MainPage;
import step_definitions.Base_Step;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends Base_Step {
    List<String> dataList = new ArrayList<>();
    @Given("User is on login page")
    public void userIsOnLoginPage(){
        driver.get("https://allegro.pl/login/form?authorization_uri=https:%2F%2Fallegro.pl%2Fauth%2Foauth%2Fauthorize%3Fclient_id%3Dtb5SFf3cRxEyspDN%26redirect_uri%3Dhttps:%2F%2Fallegro.pl%2Flogin%2Fauth%3Forigin_url%253D%25252F%25253Flogout%25253D1%26response_type%3Dcode%26state%3D6UjELJ&oauth=true");
        new MainPage(driver).AcceptCookies();
    }

    @When("User fill username field with correct username")
    public void userFillUsernameFieldWithCorrectUsername() {
        String username = "*******";
        new LoginPage(driver).FillUsernameField(username);
        dataList.add(username);
    }

    @And("User enter incorrect password")
    public void userEnterIncorrectPassword() {
        new LoginPage(driver).FillPasswordField("wrong password");

    }

    @And("User click login button")
    public void userClickLoginButton() {
        new LoginPage(driver).ClickLoginButton();
    }


    @Then("Incorrect password or login message appeared")
    public void incorrectPasswordOrLoginMessageAppeared() {
        String errorMessage = new LoginPage(driver).getErrorMessage();
        Assert.assertTrue(errorMessage.equals("Login, e-mail lub hasło są nieprawidłowe"));
    }

    @And("User close the browser")
    public void userCloseTheBrowser() {
        driver.quit();
    }

    @And("User enter correct password")
    public void userEnterCorrectPassword() {
        new LoginPage(driver).FillPasswordField("********");
    }

    @Then("Username should be displayed on main page")
    public void usernameShouldBeDisplayedOnMainPage() throws InterruptedException {
        Thread.sleep(2000);
        String loggedUser = new MainPage(driver).getUserName();
        Assert.assertEquals(dataList.get(0), loggedUser);
    }
}
