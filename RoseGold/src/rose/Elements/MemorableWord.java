package rose.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MemorableWord {
	
	private static WebElement element= null;
	
	public String processMem(String mem,String memData){
		
		int val1 = memData.indexOf(" ");
		String val2 = memData.substring(val1+1);
		int  val3= Integer.parseInt(val2);
		String fin= mem.substring(val3-1, val3);
		return(fin);
}
	
	public WebElement catch_mem1(WebDriver driver){
		element= driver.findElement(By.xpath("//div[2]/label[starts-with(text(), 'Character')]"));
	return(element);
	}
	public WebElement catch_mem2(WebDriver driver){
		element=driver.findElement(By.xpath("//div[3]/label[starts-with(text(), 'Character')]"));
		return(element);
	}
	public WebElement catch_mem3(WebDriver driver){
		element=driver.findElement(By.xpath("//div[4]/label[starts-with(text(), 'Character')]"));
		return(element);
		
	}

	public WebElement drop1(WebDriver driver){
		element=driver.findElement(By.xpath("//select[@id='char0']"));
		return(element);
	}
	public WebElement drop2(WebDriver driver){
		element=driver.findElement(By.xpath("//select[@id='char1']"));
		return(element);
	}
	public WebElement drop3(WebDriver driver){
		element=driver.findElement(By.xpath("//select[@id='char2']"));
		return(element);
	}
	
	public WebElement submit_Button(WebDriver driver){
		element=driver.findElement(By.xpath("//input[@id='memorableSubmit']"));
		return(element);
	}
	
	public String validateLogin(){
		return("Home Menu | Interflora ROSE Gold");
		
	}
}
