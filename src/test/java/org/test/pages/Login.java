package org.test.pages;

/*
@author Branislav Guduric

In this class are all functions and variables required for modeling of Login page

*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
    WebDriver driver;
    String username = "branislav.guduric";
    String correctPassword = "Lozinka123";

    By inputField_username = By.id("username");
    By inputField_password = By.id("password");

    By buttonLogin = By.className("button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername() {
        driver.findElement(inputField_username).sendKeys(username);
    }

    public void enterPassword() {
        driver.findElement(inputField_password).sendKeys(correctPassword);
    }

    public void clickLogin() {
        driver.findElement(buttonLogin).click();
    }
}