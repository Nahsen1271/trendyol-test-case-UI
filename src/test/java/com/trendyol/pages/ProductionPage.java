package com.trendyol.pages;


import com.trendyol.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductionPage {

    WebDriverWait wait= new WebDriverWait(Driver.get(),20);

    public ProductionPage(){

        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = "a.breadcrumb-item")
    public List<WebElement> randomProductName;

    @FindBy(css=".pr-in-btn.add-to-bs")
    public WebElement addToBasketButton;

    public void addToBasket(){

        int randomProductNameSize= randomProductName.size();

        String randomProName=randomProductName.get(randomProductNameSize-1).getText();
        System.out.println("randomProName = " + randomProName.toUpperCase());

        String [] getRandomName = randomProName.split(" ");
        System.out.println("getRandomName = " + getRandomName[0].toUpperCase());

        String randomProTitle=Driver.get().getTitle().toUpperCase();
        System.out.println("randomProTitle = " + randomProTitle);

        Assert.assertTrue(randomProTitle.contains(getRandomName[0].toUpperCase()));


        wait.until(ExpectedConditions.elementToBeClickable(addToBasketButton));
        addToBasketButton.click();

    }
}

