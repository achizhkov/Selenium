package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
  @Test (priority = 1,groups = { "negativeTests", "smokeTest" }) // priority sets the priority, enabled = false - disables the test
  public void incorrectUserNameTest() {
    System.out.println("Starting the test");
    // Create driver
    //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe"); //Setting the path to the driver
    System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
    //WebDriver driver = new ChromeDriver(); // creating the driver
    WebDriver driver = new FirefoxDriver();

    // Open Test Page
    String url = "https://the-internet.herokuapp.com/login"; // setting the main page url
    driver.get(url); // telling the driver to open the page
    System.out.println("The Page Is Opened");

    // Maximize Browser Window
    driver.manage().window().maximize(); // maximazing the window

    //Find username input and type in an incorrect username
    WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
    username.sendKeys("incorrectname");

    //Find password input and type in the correct password
    WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
    password.sendKeys("SuperSecretPassword!");

    //Click on the log in button
    WebElement logInButton = driver.findElement(By.className("radius"));
    logInButton.click();

    //Assertion
    WebElement errorMessage = driver.findElement(By.id("flash"));
    String expectedErrorMessage = "Your username is invalid!";
    String actualErrorMessage = errorMessage.getText();
    Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "no such message has been found");

    //Close Browser
    driver.quit();
  }

  @Test (priority = 2, enabled = true, groups = { "negativeTests" } )
  public void incorrectPasswordTest() {
    System.out.println("Starting the test");
    // Create driver
    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe"); //Setting the path to the driver
    WebDriver driver = new ChromeDriver(); // creating the driver

    // Open Test Page
    String url = "https://the-internet.herokuapp.com/login"; // setting the main page url
    driver.get(url); // telling the driver to open the page
    System.out.println("The Page Is Opened");

    // Maximize Browser Window
    driver.manage().window().maximize(); // maximazing the window

    //Find username input and type in an incorrect username
    WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
    username.sendKeys("tomsmith");

    //Find password input and type in the incorrect password
    WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
    password.sendKeys("SuperSecretPassword");

    //Click on the log in button
    WebElement logInButton = driver.findElement(By.className("radius"));
    logInButton.click();

    //Assertion
    WebElement errorMessage = driver.findElement(By.id("flash"));
    String expectedErrorMessage = "Your password is invalid!";
    String actualErrorMessage = errorMessage.getText();
    Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "no such message has been found");

    //Close Browser
    driver.quit();
  }

  //Slow down method
  private void sleep(long m) {
    try {
      Thread.sleep(m);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
