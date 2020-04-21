package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WatchesSubcategoryPage {
    public WatchesSubcategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'powystawowe')]")
    private WebElement powystatwoweFilter;
    @FindBy(xpath = "//span[contains(text(),'kup teraz')]")
    private WebElement kupTerazFilter;
    @FindBy(css = "._nem5f._1nezw")
    private WebElement changeViewButton;
    @FindBy(css = "._3e3a8_1pjFk")
    private List<WebElement> filterPriceList;
    @FindBy(css = "._pj3fi._1vx3o._9n1kg._kiiea._llaxp._1fkm6._1394d_3R_Hj._sxf3e")
    private List<WebElement> chosenFilterList;
    @FindBy(css = "._9c44d_3kZXX._9c44d_3W29v")
    private List<WebElement> adTypeResultList;
    @FindBy(css = "._9c44d_1zemI")
    private List<WebElement> priceResultList;
    @FindBy(xpath = "//dt[text()='Stan']/following-sibling::dd[1]")
    private List<WebElement> itemStateResultList;


    public List<WebElement> getChosenFilterList() {
        return chosenFilterList;
    }

    public List<WebElement> getPriceResultList() {
        return priceResultList;
    }

    public List<WebElement> getAdTypeResultList() {
        return adTypeResultList;
    }

    public List<WebElement> getItemStateResultList() {
        return itemStateResultList;
    }

    public String getFilterPriceText() {
        String filterPriceText =filterPriceList.get(0).getText();
        return filterPriceText;
    }

    public void ClickTo25ZlFiter() {
        filterPriceList.get(0).click();
    }

    public void ChangeView() {
        changeViewButton.click();
    }

    public String getAdTypeFilterText() {
       String adTypeFilterText= kupTerazFilter.getText();
       return adTypeFilterText;
    }

    public void ClickKupTerazFilter() {
        kupTerazFilter.click();
    }
    public String getItemStateFilterText(){
        String itemStateFilterText = powystatwoweFilter.getText();
        return itemStateFilterText;
    }

    public void ClickPowystawoweFilter() {
        powystatwoweFilter.click();
    }
}
