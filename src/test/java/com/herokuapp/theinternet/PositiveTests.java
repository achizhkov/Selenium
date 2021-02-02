package com.herokuapp.theinternet;
import org.openqa.selenium.WebDriver;
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
    //Slow Down Test
    sleep(3000);
    // Maximize Browser Window
    driver.manage().window().maximize();
    // Enter Username
    // Enter password
    // Click login button
    // verifications:
      //new url
      //logout button is visible
      //successfully login message
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
