package com.amazon.StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.amazon.DriverManager.driver;

public class LoginFunction {

    @Given("^user in sign in page$")
    public void user_in_sign_in_page()  {
        driver.findElement(By.cssSelector("#nav-link-yourAccount")).click();
       waitForSomeTime();
    }

    @When("^user enter valid username$")
    public void user_enter_valid_username()  {
        driver.findElement(By.id("ap_email")).sendKeys("ham427115@gmail.com");
       waitForSomeTime();

    }

    @When("^user enter valid password$")
    public void user_enter_valid_password()  {
        driver.findElement(By.id("ap_password")).sendKeys("fordfocus2005");
        waitForSomeTime();

    }

    @When("^user enter signin button$")
    public void user_enter_signin_button()  {
        driver.findElement(By.cssSelector("#signInSubmit")).click();
       waitForSomeTime();
    }

    @Then("^user should logged in successfully$")
    public void user_should_logged_in_successfully()  {

        Assert.assertTrue(driver.findElement(By.cssSelector("#nav-your-amazon")).getText().contains("kandy's Amazon"));

    }


    @When("^user enter invalid password$")
    public void userEnterInvalidPassword()  {
        driver.findElement(By.id("ap_password")).sendKeys("fordfocus2008");
        waitForSomeTime();
    }

    @Then("^user should  not logged  successfully$")
    public void userShouldNotLoggedSuccessfully()  {
        Assert.assertTrue(driver.findElement(By.cssSelector(".a-box-inner.a-alert-container")).getText().contains("There was a problem"));
    }

    @And("^user click on forgot password$")
    public void userClickOnForgotPassword()  {
        driver.findElement(By.id("auth-fpp-link-bottom")).click();
        waitForSomeTime();
    }

    @Then("^user should  navigate to reset password$")
    public void userShouldNavigateToResetPassword()  {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Password assistance "));
        waitForSomeTime();
    }



    public void waitForSomeTime(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
