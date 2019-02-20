package com.aqacources.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marina on 19.02.2019.
 */
public class AbstractPage {

    String currentPageURL;

    // Web Elements
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@id='page']")
    private WebElement divPage;

    @FindBy(xpath = "//div[@class='header_user_info']/a[@class='logout']")
    private WebElement logOut;

    @FindBy(xpath = "//form[@id='login_form']/descendant::div[@class='form-group']/input[@data-validate='isEmail']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//form[@id='login_form']/descendant::div[@class='form-group']/span/input[@type='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement submitButton;

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(divPage));
    }

    /**
     * Click on Sign In link
     *
     * @return new instance of LoginPage
     */
    public LoginPage clickSignInLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        return new LoginPage(driver);
    }

    /**
     * get Current URL
     * @param driver
     * @return
     */
    public String getTitle (WebDriver driver) {
        currentPageURL = driver.getTitle();
        return currentPageURL;
    }

    /**
     * Click Log Out
     */
    public void logOut() {
        logOut.click();
    }


    /**
     * Enter login and password and click to Submit Button
     * @param login
     * @param password
     */
    public MyAccoutPage signIn (String login, String password){
        fieldLogin.sendKeys(login);
        fieldPassword.sendKeys(password);
        submitButton.click();
        return new MyAccoutPage(driver);
    }

}

