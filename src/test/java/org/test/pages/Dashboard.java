package org.test.pages;

/*
@author Branislav Guduric

In this class are all functions and variables required for modeling of main page

*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    WebDriver driver;
    public Dashboard(WebDriver driver) { this.driver = driver; }

    By buttonDeleteProfile = By.className("button");

    public void deleteProfile()
    {
            driver.findElement(buttonDeleteProfile).click();
    }
}
