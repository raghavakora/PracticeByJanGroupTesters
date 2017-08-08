package com.Practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SanityTestSuite {
    private WebDriver driver;
    public String email = "test12121@gmail.com";


    @Before
    public void OpenWindow() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\katuk_000\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://demo.nopcommerce.com/register");
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
             public void Registration() {


        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("Unit");
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dropdown.selectByIndex(23);
        Select dropdown1 = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dropdown1.selectByVisibleText("April");
        Select dropdown2 =new Select(driver.findElement(By.name("DateOfBirthYear")));
        dropdown2 .selectByVisibleText("1987");
        driver.findElement(By.id("Email")).sendKeys("test123@test.com");
        driver.findElement(By.id("Company")).sendKeys("cadbury");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.id("Password")).sendKeys("idontknow");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("idontknow");
        driver.findElement(By.id("register-button")).click();
        Assert.assertTrue("Your registration completed",driver.getTitle().startsWith("Your registration completed"));


    }


    @After
public void CloseBrowser(){

    driver.close();
        driver.quit();
    }



    }


