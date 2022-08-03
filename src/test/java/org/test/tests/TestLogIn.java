package org.test.tests;

/*

@author Branislav Guduric

In this class are FrontEnd automatic tests for website https://qa-interview.united.cloud/login
Testing include:

1st test
This test is used to follow the flow of creating a new Profile for a child

2nd test
This test check entire flow from creating a new Profile for a child to deleting that profile

3rd test
This test is used for error checking. During the creation of a new Profile, if invalid year is entered,
test fails

*/

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.pages.ChooseProfile;
import org.test.pages.CreateProfile;
import org.test.pages.Dashboard;
import org.test.pages.Login;

import java.time.Year;


public class TestLogIn {
    WebDriver driver;
    String webdriverSystemAddress = "chromedriver104.exe";
    String webdriverChromeDriver = "webdriver.chrome.driver";
    String urlEON = "https://qa-interview.united.cloud/";

    @Test
    public void testCreateNewProfile() throws InterruptedException {
        driver = TestSetup();

        createNewProfile(driver);

        driver.close();
    }

    @Test
    public void testCreateAndDeleteProfile() throws InterruptedException
    {
        driver = TestSetup();

        createNewProfile(driver);
        deleteProfile(driver);

        driver.close();
    }

    @Test
    public void testTryToCreateProfileWithInvalidYear() throws  InterruptedException
    {
        driver = TestSetup();

        TryToCreateProfileWithInvalidYear(driver);

        driver.close();
    }

    public WebDriver TestSetup()
    {
        System.setProperty(webdriverChromeDriver,webdriverSystemAddress);
        System.getProperty("user.dir");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(urlEON);
        return driver;
    }

    public void createNewProfile(WebDriver driver) throws InterruptedException {
        Login pagelogin = new Login(driver);
        pagelogin.enterUsername();
        pagelogin.enterPassword();
        pagelogin.clickLogin();

        ChooseProfile pageChooseProfile = new ChooseProfile(driver);
        pageChooseProfile.createNewProfile();

        CreateProfile pageCreateProfile = new CreateProfile(driver);
        pageCreateProfile.createProfile_0_6();
    }

    public void TryToCreateProfileWithInvalidYear(WebDriver driver) throws InterruptedException {
        Login pagelogin = new Login(driver);
        pagelogin.enterUsername();
        pagelogin.enterPassword();
        pagelogin.clickLogin();

        ChooseProfile pageChooseProfile = new ChooseProfile(driver);
        pageChooseProfile.createNewProfile();

        CreateProfile pageCreateProfile = new CreateProfile(driver);

        pageCreateProfile.createProfileInvalidYear();


        if (pageCreateProfile.randomYearInt < 1920 && pageCreateProfile.randomYearInt > Integer.parseInt(Year.now().toString()))
        {
            System.out.println("Invalid year entered");
            Assert.fail();
        }
    }

    public void deleteProfile(WebDriver driver)
    {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.deleteProfile();
    }
}
