package com.aqacources.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Marina on 19.02.2019.
 */
public class LoginPage extends AbstractPage {

    String loginPageURL;



    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
