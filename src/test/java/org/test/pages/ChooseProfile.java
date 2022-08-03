package org.test.pages;

/*
@author Branislav Guduric

In this class are all functions and variables required for modeling of ChoseProfile page

*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ChooseProfile {
    WebDriver driver;

    public ChooseProfile(WebDriver driver)
    {
        this.driver = driver;
    }
    //By buttonCreateNewProfile = By.className("button");
    By buttonCreateNewProfile = By.className("button");

    public void createNewProfile() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(buttonCreateNewProfile).click();
    }
}
