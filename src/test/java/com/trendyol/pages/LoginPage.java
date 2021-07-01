package com.trendyol.pages;

import com.trendyol.utilities.BrowserUtils;
import com.trendyol.utilities.ConfigurationReader;
import com.trendyol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public LoginPage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "(//span[@class='homepage-popup-gender'])[2]")
    public WebElement popUp;

    @FindBy (xpath = "(//p[@class='link-text'])[1]")
    public WebElement GirisYap;

    @FindBy(id="login-email")
    public WebElement userName;

    @FindBy(id="login-password-input")
    public WebElement passwordInput;

    @FindBy(xpath="//button[@class='q-primary q-fluid q-button-medium q-button submit']")
    public WebElement loginButton;

    WebDriverWait wait= new WebDriverWait(Driver.get(),10);
    public void login(){

        String EPosta = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys(EPosta);

        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        BrowserUtils.waitFor(3);
    }
}
