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
import page_object.SearchResultPage;


import static org.hamcrest.CoreMatchers.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Searching_Steps extends Base_Step{
    private List<String> inputList = new ArrayList<>();
    private List<Integer> bad = new ArrayList<>();
    private List<Integer> good = new ArrayList<>();


    @Given("User is on main page and accept privacy policy")
    public void userIsOnMainPageAndAcceptPrivacyPolicy() {
        new MainPage(driver).AcceptCookies();
    }



    @When("User click on searching bar")
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
        List<WebElement> resultList = new SearchResultPage(driver).getSearchResultList();
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getText().toLowerCase().contains(inputList.get(0))) {
                good.add(i);
            } else {
                bad.add(i);
            }
        }
        System.out.println("Liczba ogłoszeń, których tytuły zawierają słowo wyszukiwane: " + good.size());
        System.out.println("Liczba ogłoszeń, których tytuły nie zawierają słowa wyszukiwanego: " + bad.size());

    }

    @And("Searched word should be visible on the top of page")
    public void searchedWordShouldBeVisibleOnTheTopOfPage() {
        SearchResultPage resultPage = new SearchResultPage(driver);
        String keyWord = resultPage.getSearchingTitle();
        Assert.assertEquals(inputList.get(0), keyWord);
    }

    @And("Result page should contains {int} ads")
    public void resultPageShouldContainsAds(int amount) {
        List<WebElement> resultList = new SearchResultPage(driver).getSearchResultList();
        Assert.assertEquals(amount, resultList.size());
        driver.quit();
    }
}

