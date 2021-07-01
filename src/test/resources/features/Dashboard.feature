
@wip
Feature: Trendyol Task
  Background:
  Given Login Functionality


  Scenario: Verify that boutique images under each Tab is displayed
    When User should be able to click Tabs and all the images should be displayed

  Scenario: Verify that a production can be selected randomly and adding it to the cart
    Given User should be able to click a production randomly
    When Verify that the product images are displayed
    And User should be able to go to details of any product
    And User should able to add the product to the cart
