package org.test.pages;

/*
@author Branislav Guduric

In this class are all functions and variables required for modeling of CreateProfile page

*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateProfile {
    WebDriver driver;
    String randomYear;
    public int randomYearInt;

    By inputFieldName = By.id("profile-name");
    By inputFieldYears = By.id("year");

    By buttonAge_0_6 = By.cssSelector("label[for='AGE_0_6']");

    By buttonAge_18_Plus = By.cssSelector("label[for='AGE_18_PLUS']");
    By buttonCreateProfile = By.cssSelector("button[type='submit']");

    public CreateProfile(WebDriver driver)
    {
        this.driver = driver;
    }

    public void createProfile_0_6() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(inputFieldName).sendKeys("Child 0-6");
        driver.findElement(buttonAge_0_6).click();

        Thread.sleep(1000);

        List<WebElement> avatars = new ArrayList<>();
        avatars = driver.findElements(By.xpath("//*"));
        int maxAvatars = avatars.size();
        Random random = new Random();
        int randomAvatar = random.nextInt(maxAvatars);
        avatars.get(randomAvatar).click();
        driver.findElement(buttonCreateProfile);
    }

    public void createProfileInvalidYear() throws InterruptedException {
        driver.findElement(inputFieldName).sendKeys("Invalid");
        driver.findElement(buttonAge_18_Plus).click();

        Random random = new Random();
        randomYear = Integer.toString(random.nextInt(1900));
        randomYearInt = Integer.parseInt(randomYear);

        driver.findElement(inputFieldYears).sendKeys(randomYear);

        Thread.sleep(2000);

        List<WebElement> avatars = new ArrayList<>();
        avatars = driver.findElements(By.xpath("//*"));
        int maxAvatars = avatars.size();
        Random randomAvatars = new Random();
        int randomAvatar = randomAvatars.nextInt(maxAvatars);
        avatars.get(randomAvatar).click();
        driver.findElement(buttonCreateProfile);
    }
}
