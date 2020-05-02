package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private  WebDriver driver;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "._13q9y._8hkto._11eg6._7qjq4._ey68j")
    private WebElement acceptCookies;
    @FindBy(css = "._d25db_3K7x6._14uqc")
    private WebElement clickSearchBar;
    @FindBy(css = "._d25db_1t06j._13q9y._8tsq7._1q2ua")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@href='/dzial/moda']")
    private WebElement fashionCategoryButton;
    @FindBy(xpath = "//div[@data-dropdown-id='user_dropdown']")
    private WebElement userDropdown;
    @FindBy(xpath = "//a[@data-role='register-button']")
    private WebElement registerButton;
    @FindBy(css = "._1fwkl._1h7wt._9hx3e._1vx3o._lsy4e._jl1m8._1ue2y._1k1q2._16qww._6dhbr._fee54_3DeiY")
    private WebElement loggedUserName;
    @FindBy(xpath = "//a[@href='/moje-konto']")
    private WebElement myAccountButton;

    public void ClickMyAccountButton(){
        myAccountButton.click();
    }


    public String getUserName(){
        return loggedUserName.getText();
    }

    public void ClickRegisterButton(){
        registerButton.click();
    }

    public void UserDropdownClick(){
        userDropdown.click();
    }


    public void ClickFashionCategoryButton() {

        fashionCategoryButton.click();
    }

    public void ClickSearchButton() {
        searchButton.click();
    }

    public void FillSearchBar(String text) {
        clickSearchBar.sendKeys(text);
    }

    public void ClickSearchBar() {
        clickSearchBar.click();
        clickSearchBar.clear();
    }

    public void AcceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(acceptCookies));
        acceptCookies.click();


    }


}
