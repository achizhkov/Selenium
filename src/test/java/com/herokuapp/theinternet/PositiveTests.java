package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {

  @Test
  public void loginTest() {
    System.out.println("Starting the test");
    // Create driver
    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    // Open Test Page
    String url = "https://the-internet.herokuapp.com/";
    driver.get(url);
    System.out.println("The Page Is Opened");
    // Maximize Browser Window
    driver.manage().window().maximize();
    //Slow Down Test
    sleep(3000);
    // Enter Username
    WebElement username = driver.findElement(By.id("username"));
    // Enter password
    WebElement password = driver.findElement(By.name("password"));
    // Click login button
    WebElement logInButton = driver.findElement(By.tagName("button"));
    // verifications:
      //new url
      //logout button is visible
    WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
      //successfully login message
    WebElement successMessage = driver.findElement(By.cssSelector("div#flash")));
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
