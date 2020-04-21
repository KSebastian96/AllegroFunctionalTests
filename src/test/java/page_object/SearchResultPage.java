package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {


    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "._11fdd_1KRNF")
    private WebElement searchingTitle;

    public String getSearchingTitle() {
        String searchingText = searchingTitle.getText();
        return searchingText;
    }


    @FindBy(css = "._9c44d_1LBF0")

    private List<WebElement> searchResultList;

    public List<WebElement> getSearchResultList() {
        return searchResultList;
    }
}
