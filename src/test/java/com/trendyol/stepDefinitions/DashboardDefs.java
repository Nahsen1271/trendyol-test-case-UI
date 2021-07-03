package com.trendyol.stepDefinitions;

import com.trendyol.pages.BoutiquePage;
import com.trendyol.pages.DashboardPage;
import com.trendyol.pages.LoginPage;
import com.trendyol.pages.ProductionPage;
import com.trendyol.utilities.BrowserUtils;
import com.trendyol.utilities.ConfigurationReader;
import com.trendyol.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Random;

public class DashboardDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    BoutiquePage boutiquePage = new BoutiquePage();
    ProductionPage productionPage = new ProductionPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();


    @Given("Login Functionality")
    public void login_Functionality() {

        //Login page should be opened
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        loginPage.popUp.click();
        loginPage.GirisYap.click();
        BrowserUtils.waitFor(1);
        //login with valid credentials
        loginPage.login();

    }

    @Then("User should be able to click Tabs and all the images should be displayed")
    public void user_should_be_able_to_click_Tabs_and_all_the_images_should_be_displayed() {
        try {
            for (int i = 0; i < dashboardPage.tabs.size(); i++) { //click on TABS one by one to see on the web page
                dashboardPage.tabs.get(i).click();
                BrowserUtils.waitFor(5);

                String category = dashboardPage.tabs.get(i).getText();
                String [] Category =category.split(" ");
                String title= Driver.get().getTitle().toUpperCase();
                System.out.println(title);
                System.out.println(Category[0]);
                Assert.assertTrue(title.contains(Category[0]));


                jse.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.downToPage); //Scroll down the page
                BrowserUtils.waitFor(1);

                for (int j = 0; j < dashboardPage.boutiqueImages.size(); j++) {    // to  check if all the images displayed or not.
                    Assert.assertTrue(dashboardPage.boutiqueImages.get(j).isDisplayed());

                }
                int totalImage = dashboardPage.boutiqueImages.size();
                System.out.println(category + " = " + totalImage);     // print out the category name and total images

                jse.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.upToPage); // Scroll up the page to able to click tags.

                BrowserUtils.waitFor(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Given("User should be able to click a production randomly")
    public void user_should_be_able_to_click_a_production_randomly() {
        Random rd = new Random();
        int randomTab = rd.nextInt(dashboardPage.tabs.size()-1);
       dashboardPage.selectRandomTab(randomTab);
        String category = dashboardPage.tabs.get(randomTab).getText();
        String [] Category =category.split(" ");
        String title= Driver.get().getTitle().toUpperCase();
        System.out.println("title  : "+title);
        System.out.println("Category First Text :" + Category[0]);
        Assert.assertTrue(title.contains(Category[0]));

        jse.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.downToPage); // Scroll down the page to get all images
        BrowserUtils.waitFor(1);
       dashboardPage.selectRandomBoutique();
    }

    @When("Verify that the product images are displayed")
    public void verify_that_the_product_images_are_displayed() {

            jse.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.downToPage); // Scroll down the page to get all images
            BrowserUtils.waitFor(1);
            int productListSize= boutiquePage.productList.size();
        System.out.println("productListSize = " + productListSize);
        try {
            for (int j = 0; j < productListSize; j++) {
                Assert.assertTrue(boutiquePage.productList.get(j).isDisplayed());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("User should be able to go to details of any product")
    public void user_should_be_able_to_go_to_details_of_any_product() {
       boutiquePage.chooseRandomProduct();
       BrowserUtils.waitFor(2);
    }

    @When("User should able to add the product to the cart")
    public void user_should_able_to_add_the_product_to_the_cart() {
        productionPage.addToBasket();
        BrowserUtils.waitFor(2);
    }




}
