package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page_object.AdPage;
import page_object.CartPage;
import page_object.MainPage;
import page_object.ThermometersSubcategoryPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddingToCartSteps extends Base_Step {
    List<Double> dataList = new ArrayList<Double>();
    @Given("User accepted privacy policy and proceed to thermometers subcategory")
    public void userAcceptedPrivacyPolicyAndProceedToThermometersSubcategory() {
        new MainPage(driver).AcceptCookies();
        driver.get("https://allegro.pl/kategoria/urzadzenia-medyczne-termometry-258798");

    }

    @When("User click random ad")
    public void userClickRandomAd() {
        List<WebElement> adsList = new ThermometersSubcategoryPage(driver).getAdsList();
        Random random = new Random();
        int randomAd = random.nextInt(adsList.size());
        adsList.get(randomAd).click();
    }

    @And("Fill amount field with (.*)")
    public void fillAmountFieldWithAmount(String amount) {
        new AdPage(driver).FillAmountField(amount);
        double amountDouble = Double.parseDouble(amount);
        String adPrice = new AdPage(driver).getAdPrice();
        String adPriceArray[] = adPrice.split(",");
        String złPrice = adPriceArray[0];
        String grPriceArray[] = adPriceArray[1].split("zł");
        String grPrice = grPriceArray[0];
        String completeGrPrice = "0." + grPrice;
        double złPriceDouble = Double.parseDouble(złPrice);
        double grPriceDouble = Double.parseDouble(completeGrPrice);
        double adPriceDouble = złPriceDouble + grPriceDouble;
        dataList.add(amountDouble);
        dataList.add(adPriceDouble);


    }

    @And("User click add to cart button")
    public void userClickAddToCartButton() {
        new AdPage(driver).ClickAddToCartButton();
    }

    @And("User click proceed to cart button")
    public void userClickProceedToCartButton() {
        new AdPage(driver).ClickProceedToCartButton();
    }

    @Then("Total price in cart should be correct")
    public void totalPriceInCartShouldBeCorrect() {
        String totalPriceString = new CartPage(driver).getTotalPrice();
        String totalPriceStringArray[] = totalPriceString.split(",");
        String totalPricezł = totalPriceStringArray[0];
        String totalPriceGrArray[] = totalPriceStringArray[1].split("zł");
        String PriceGr = totalPriceGrArray[0];
        String totalPriceGr = "0." + PriceGr;
        double totalPricezłDouble = Double.parseDouble(totalPricezł);
        double totalPriceGrDouble = Double.parseDouble(totalPriceGr);
        Double totalPrice = totalPricezłDouble + totalPriceGrDouble;
        Assert.assertTrue((dataList.get(0) * dataList.get(1)) == totalPrice);

    }

    @And("Price per unit should be correct")
    public void pricePerUnitShouldBeCorrect() {
        String pricePerUnitString = new CartPage(driver).getPricePerUnit();
        String pricePerUnitStringArray[] = pricePerUnitString.split(" ");
        String UnitPriceArray[] = pricePerUnitStringArray[2].split(",");
        String unitPriceGrString = "0." + UnitPriceArray[1];
        double unitPriceZł = Double.parseDouble(UnitPriceArray[0]);
        double unitPriceGr = Double.parseDouble(unitPriceGrString);
        double unitPrice = unitPriceZł + unitPriceGr;
        Assert.assertTrue(dataList.get(1) == unitPrice);
        driver.quit();
    }
}
