package test.java;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import rose.Elements.LoginRose;
import rose.Elements.MemorableWord;
import rose.Elements.OpenURL;

public class RoseTestCase {
	public WebDriver RoseBrowser;
	public EventFiringWebDriver eRose;
	public String url;
	public String userName;
	public String uPass;
	OpenURL openurl= new OpenURL();
	LoginRose login = new LoginRose();
	MemorableWord memword= new MemorableWord();
	//LoginPageObjects loginObjects= new LoginPageObjects();
	public String mem;
	
	
	
	@Test(groups={"openurl","login"})
	public void validateURL() throws Throwable{
		RoseBrowser.get(url);
		//expectedOP=openurl.validateURL();
		try{
			Assert.assertEquals(RoseBrowser.getTitle(), openurl.validateURL());
		}catch(Throwable e){
			System.out.println("Login Page is not displayed");
			throw(e);
		}
System.out.println("Method: validateURL");	
	}

	@Test(dependsOnGroups="openurl", groups="login")
  	public void loginToRose() {
	  login.user_name_object(RoseBrowser).sendKeys(userName);
	  login.password_Field(RoseBrowser).sendKeys(uPass);
	  login.submit_Button(RoseBrowser).click();
	 
	  Assert.assertEquals(RoseBrowser.getTitle(),login.loginValidate());
		System.out.println("Method: loginTORose");
	
		}
  
    
@Test(dependsOnGroups={"openurl","login"},groups="mem")
public void memWord(){
	
	
	
	String process;
	String firstMem = memword.catch_mem1(RoseBrowser).getText();
	Select drop1 = new Select(memword.drop1(RoseBrowser));
	process=memword.processMem(mem, firstMem);
	drop1.selectByValue(process);
	
	String secMem = memword.catch_mem2(RoseBrowser).getText();
	Select drop2 = new Select(memword.drop2(RoseBrowser));
	process=memword.processMem(mem, secMem);
	drop2.selectByValue(process);
	
	String thirdMem = memword.catch_mem3(RoseBrowser).getText();
	Select drop3 = new Select(memword.drop3(RoseBrowser));
	process=memword.processMem(mem, thirdMem);
	drop3.selectByValue(process);
	memword.submit_Button(RoseBrowser).click();
	Assert.assertEquals(RoseBrowser.getTitle(), memword.validateLogin());
	System.out.println("Method: memWord");
}	

	

@BeforeSuite
public void beforeSuite() throws Exception {
	RoseBrowser=new FirefoxDriver();
	RoseBrowser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   // eRose =new EventFiringWebDriver(RoseBrowser);
	url = "https://rose.uat1.interfloratest.co.uk/interflora/login.jsp";
	  
		try{
			//Initialize the data from Excel with Path
		FileInputStream xlFile = new FileInputStream("src//RoseDataContainer//testData.xls");
		//Load book
		HSSFWorkbook book1 = new HSSFWorkbook(xlFile);
		//Load the Workbook Sheet
		HSSFSheet sheet1 = book1.getSheet("LoginData");
		//Get the Row Values
		HSSFRow row1 = sheet1.getRow(1);
		//Getting Cell Values from Excel
		HSSFCell cel1 = row1.getCell(1);
		HSSFCell cel2 = row1.getCell(2);
		HSSFCell cel3 = row1.getCell(3);
		//Assign Cell values to Variables
		userName= cel1.getStringCellValue();
		uPass = cel2.getStringCellValue();
		mem = cel3.getStringCellValue();
		//System.out.println(userName);
		}catch(Exception F){
			System.out.println("File Not Found");
			throw(F);
		}
		System.out.println("BeforeSuit");
	}
}
