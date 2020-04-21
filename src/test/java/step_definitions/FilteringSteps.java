package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page_object.FashionCategoryPage;
import page_object.MainPage;
import page_object.OnSubcategoryPage;
import page_object.WatchesSubcategoryPage;

import java.util.List;


public class FilteringSteps extends Base_Step {


    @Given("User is on main page and privacy policy is accepted")
    public void userIsOnMainPageAndPrivacyPolicyIsAccepted() {
        new MainPage(driver).AcceptCookies();
    }

    @When("User click fashion category")
    public void userClickFashionCategory() {
        new MainPage(driver).ClickFashionCategoryButton();
    }


    @And("User click on subcategory")
    public void userClickOnSubcategory() {
        new FashionCategoryPage(driver).ClickOnSubcategoryButton();
    }


    @And("User click watches subcategory")
    public void userClickWatchesSubcategory() {
        new OnSubcategoryPage(driver).ClickWatchesSubcategory();
    }

    @And("User click powystawowe filter")
    public void userClickPowystawoweFilter() {
        new WatchesSubcategoryPage(driver).ClickPowystawoweFilter();
    }

    @And("User click kup teraz filter")
    public void userClickKupTerazFilter() throws InterruptedException {
        new WatchesSubcategoryPage(driver).ClickKupTerazFilter();
        Thread.sleep(2000);
    }

    @And("User change view")
    public void userChangeView() {
        new WatchesSubcategoryPage(driver).ChangeView();
    }

    @And("User click below 25zł filter")
    public void userClickBelowZłFilter() throws InterruptedException {
        Thread.sleep(2000);
        new WatchesSubcategoryPage(driver).ClickTo25ZlFiter();
    }

    @Then("Chosen filter should be visible on page under the category section")
    public void chosenFilterShouldBeVisibleOnPageUnderTheCategorySection() {
        String adTypeFilterText = new WatchesSubcategoryPage(driver).getAdTypeFilterText();
        String itemStateFilterText = new WatchesSubcategoryPage(driver).getItemStateFilterText();
        List<WebElement> chosenFilterList = new WatchesSubcategoryPage(driver).getChosenFilterList();
        String chosenItemStateFilter = chosenFilterList.get(0).getText();
        String chosenItemStateFilterArray[] = chosenItemStateFilter.split(": ");
        String chosenAdTypeFilter = chosenFilterList.get(1).getText();
        String chosenAdTypeFilterArray[] = chosenAdTypeFilter.split(": ");
        Assert.assertEquals(itemStateFilterText, chosenItemStateFilterArray[1]);
        Assert.assertEquals(adTypeFilterText, chosenAdTypeFilterArray[1]);
        Assert.assertEquals("cena: do 25 zł", chosenFilterList.get(2).getText());
    }


    @And("Ads should match the filters")
    public void adsShouldMatchTheFilters() {
        List<WebElement> itemStateResultList = new WatchesSubcategoryPage(driver).getItemStateResultList();
        List<WebElement> adTypeResultList = new WatchesSubcategoryPage(driver).getAdTypeResultList();
        List<WebElement> priceResultList = new WatchesSubcategoryPage(driver).getPriceResultList();
        String adTypeFilterText = new WatchesSubcategoryPage(driver).getAdTypeFilterText();
        for (int i = 0; i < itemStateResultList.size(); i++) {
            Assert.assertEquals("Ogłoszenie nr " + " nie spełnia wymogów filtra stan", "Powystawowy", itemStateResultList.get(i).getText());
        }
        for (int i = 0; i < adTypeResultList.size(); i++) {
            Assert.assertEquals("Ogłoszenie nr " + i + " nie spełnia wymogów filtra typ ogłoszenia", adTypeFilterText, adTypeResultList.get(i).getText());
        }
        for (int i = 0; i < priceResultList.size(); i++) {
            String priceZłotych = priceResultList.get(i).getText();
            String priceZłotychArray[] = priceZłotych.split(",");
            String priceGroszyArray[] = priceZłotychArray[1].split("zł");
            String priceGroszy = priceGroszyArray[0];
            String priceTotalGroszy = "0." + priceGroszy;
            double priceGroszyDouble = Double.parseDouble(priceTotalGroszy);
            double priceZłotychDouble = Double.parseDouble(priceZłotychArray[0]);
            double priceTotal = priceZłotychDouble + priceGroszyDouble;
            Assert.assertTrue("Ogłoszenie nr " + i + " Nie spełnia wymogów filtra ceny", priceTotal <= 25);
        }

    }
}
