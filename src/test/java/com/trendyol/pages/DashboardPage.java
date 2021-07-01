package com.trendyol.pages;

import com.trendyol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class DashboardPage {
    public DashboardPage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css=".tab-link")
    public List<WebElement> tabs;

    @FindBy(xpath="//span[@class ='image-container']/img")
    public List<WebElement> boutiqueImages;

    @FindBy(className ="footer__wrapper--sectionTitle")
    public WebElement downToPage;

    @FindBy(linkText = "Yardım & Destek")
    public WebElement upToPage;



    public void selectRandomTab (int randomTab){

        tabs.get(randomTab).click();
        System.out.println(tabs.get(randomTab).getText());
    }

    public void selectRandomBoutique (){
        Random rd = new Random();
        int randomBoutique= rd.nextInt(boutiqueImages.size()-1);
        boutiqueImages.get(randomBoutique).click();
    }


}
