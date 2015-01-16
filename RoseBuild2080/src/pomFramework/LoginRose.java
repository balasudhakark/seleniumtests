package pomFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginRose {
	private static WebElement element = null;
	//This method is used for identify the USERNAME field and return value to webelement 'element'.
	public WebElement user_name_object(WebDriver driver){
	element= driver.findElement(By.xpath("//input[@id='j_username']"));
	return(element);
	//This method is used for identify the PASSWORD field.
	}
	public WebElement password_Field(WebDriver driver){
	element= driver.findElement(By.xpath("//input[@id='j_password']"));
	return(element);
	}
	public WebElement submit_Button(WebDriver driver){
	element= driver.findElement(By.xpath("//input[@id='login_button']"));
	return(element);
	}
	//This method is used for validating login.
	public String loginValidate(){
	return("Memorable Word Page | Interflora ROSE Gold");
	}

}
