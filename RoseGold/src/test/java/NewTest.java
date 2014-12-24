package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  WebDriver browser = new FirefoxDriver();
	  browser.get("https://www.google.com");
	  browser.wait();
	  browser.findElement(By.xpath("//div[@id='sb_ifc0']")).sendKeys("Hello");
	  
  }
}
