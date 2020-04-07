package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.MainPage;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;




public class Searching_Steps {
    public List<String> inputList = new ArrayList<>();
    private WebDriver driver;


    @Given("User is on main page")
    public void userIsOnMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allegro.pl/");
    }

    @When("User accept privacy policy")
    public void userAcceptPrivacyPolicy() {
        new MainPage(driver).AcceptCookies();

    }

    @And("User click on searching bar")
    public void userClickOnSearchingBar() {
        new MainPage(driver).ClickSearchBar();
    }

    @And("User fill the searching field with (.*)")
    public void userFillTheSearchingFieldWithWantedItemName(String text) {
        new MainPage(driver).FillSearchBar(text);
        inputList.add(text);
    }


    @And("User click search button")
    public void userClickSearchButton() {
        new MainPage(driver).ClickSearchButton();
    }


    @Then("Results should contains searched word")
    public void resultsShouldContainsSearchedWord() {
        List<WebElement> resultList = new MainPage(driver).getSearchResultList();
        for (int i = 0; i < resultList.size(); i++) {
            Assert.assertThat(resultList.get(i).getText().toLowerCase(), containsString(inputList.get(0)));

        }
    }
}
