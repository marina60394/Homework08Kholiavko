package com.aqacources.tests.tests;

import com.aqacources.tests.pages.LoginPage;
import com.aqacources.tests.pages.HomePage;
import com.aqacources.tests.pages.MyAccoutPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Marina on 19.02.2019.
 */
public class CheckUesrInformationTest {

    // Instance of WebDriver
    private WebDriver driver;

    // URL
    private final String URL = "http://automationpractice.com/index.php";

    /**
     * Set up method
     */
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * Open site and authorize user, check customer name and sign out
     */
    @Test
    public void testOpenSiteAndClickTheLinkTest() {

        String loginPageURL;

        String myAcoountPageURL;

        // Open site
        driver.get(URL);

        // Initialize Home page
        HomePage homePage = new HomePage(driver);

        // Click on Sign In link
        LoginPage loginPage = homePage.clickSignInLink();

        // get URL for Login Page
        loginPageURL =  homePage.getURL(driver);

        // Sign In with login and password
        loginPage.signIn("marina60394@gmail.com", "65582012marina");

        // Initialize MyAccountPage
        MyAccoutPage myAccoutPage = new MyAccoutPage(driver);

        // check customer name
        myAccoutPage.checkcustomerName();

        // log out
        myAccoutPage.logOut();

        // get URL after Sign Out
        myAcoountPageURL = myAccoutPage.getURL(driver);

        // check that page after click Sign In and page when user is Log Out is the same
        Assert.assertEquals(loginPageURL, myAcoountPageURL);

    }

    /**
     * Quit the driver
     */
    @After
    public void tearDown() {
        driver.quit();
    }

}
