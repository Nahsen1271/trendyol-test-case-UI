package com.trendyol.pages;

import com.trendyol.utilities.BrowserUtils;
import com.trendyol.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BoutiquePage {
    public BoutiquePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//div[@class ='image-container']")
    public List<WebElement> productList;

    public void chooseRandomProduct (){
        Random rd = new Random();
        int randomProduct = rd.nextInt(productList.size()-1);
        BrowserUtils.waitFor(1);
        productList.get(randomProduct).click();


    }



}

