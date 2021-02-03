package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

  @Test
  public void loginTest() {
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
    //Slow Down Test
    //sleep(3000);

    // Enter Username
    WebElement username = driver.findElement(By.id("username")); // searching for the element by ID
    username.sendKeys("tomsmith"); //Entering Login

    // Enter password
    WebElement password = driver.findElement(By.name("password")); // searching for the element by value=name
    password.sendKeys("SuperSecretPassword!"); //Entering Password

    // Click login button
    WebElement logInButton = driver.findElement(By.tagName("button")); // searching for the element by tagName
    logInButton.click();

    // verifications:
    String expectedUrl = "https://the-internet.herokuapp.com/secure"; //checking for the expected url
    String actualUrl = driver.getCurrentUrl(); // getting the current url
    Assert.assertEquals(actualUrl,expectedUrl, "The page is not as expected"); // TestNG method allows us to compare strings and add a message if there is an error in the assertion
    //logout button is visible
    WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
    Assert.assertTrue(logOutButton.isDisplayed(), "The element is not found"); // Here we use a condition so IF the button is visible assert will pass
    //successfully login message
    WebElement successMessage = driver.findElement(By.cssSelector("div#flash")); // We find the element that contains the test message
    String expectedMessage ="You logged into a secure area!"; // We create a variable with the expected message
    String actualMessage = successMessage.getText(); // We are taking the text from the element and checking it. NOTE: .getText() method will take all the text in all child elements so if we use it like this the test will fail
    //Assert.assertEquals(actualMessage,expectedMessage, "The expected message is not found"); //We are comparing the text using the Assert method. NOTE it won't work, look up
    Assert.assertTrue(actualMessage.contains(expectedMessage), "The expected message is not found, or different"); // We are simply checking if actual message repeats the expected message
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