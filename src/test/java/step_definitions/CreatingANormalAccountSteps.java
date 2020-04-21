package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import page_object.MainPage;
import page_object.RegistrationPage;

public class CreatingANormalAccountSteps extends Base_Step {
    @Given("Main page opened, cookies accepted")
    public void mainPageOpenedCookiesAccepted() {
        new MainPage(driver).AcceptCookies();
    }

    @When("User proceed to registration page")
    public void userProceedToRegistrationPage() {
    new MainPage(driver).UserDropdownClick();
    new MainPage(driver).ClickRegisterButton();
    }


    @And("User fill e-mail field with (.*)")
    public void userFillEMailFieldWith(String text) {
        new RegistrationPage(driver).FillEmailField(text);
    }

    @And("User fill password field with (.*)")
    public void userFillPasswordFieldWithPassword(String password) {
        new RegistrationPage(driver).FillPasswordField(password);

    }

    @And("User enter (.*), (.*) and (.*) of birth")
    public void userEnterDayMonthAndYearOfBirth(String day, String month, String year) {
        new RegistrationPage(driver).FillDayOfBirth(day);
        new RegistrationPage(driver).FillMonthOfBirth(month);
        new RegistrationPage(driver).FillYearOfBirth(year);

    }

    @And("User accept terms of use")
    public void userAcceptTermsOfUse() {
        new RegistrationPage(driver).AcceptTermsOfUse();
    }

    @And("User click create account button")
    public void userClickCreateAccountButton() {
    new RegistrationPage(driver).ClickCreateAccountButton();
    }
}
