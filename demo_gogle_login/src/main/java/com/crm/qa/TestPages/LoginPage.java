package com.crm.qa.TestPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement Useremail;														// User-name
	
	@FindBy(xpath="//div[@id=\"identifierNext\"]")									// Continue button
	WebElement UserContinue;
	
	@FindBy(xpath="//input[@name='password']")									// Password fill
	WebElement UserPassword;
	
	@FindBy(xpath="//div[@id=\"passwordNext\"]")
	WebElement Password_Next;
	
	@FindBy(xpath="//span[contains(text(),'Wrong password. Try again or click Forgot password to reset it.')]")
	WebElement Wrong_Password_Error;
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	
	public HomePage login(String un, String pwd) throws Exception{
		Thread.sleep(2000);
		Useremail.sendKeys(un);
		UserContinue.click();
		UserPassword.sendKeys(pwd);
		Thread.sleep(2000);
		Password_Next.click();
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", Login_Button);
//		    	
		Thread.sleep(5000);
		return new HomePage();
	}
	
	public HomePage NegativeLogin(String Negative_Un, String Negative_pwd) throws Exception{
		Thread.sleep(2000);
		Useremail.sendKeys(Negative_Un);
		UserContinue.click();
		UserPassword.sendKeys(prop.getProperty("Negative_pwd"));
		Thread.sleep(2000);
		Password_Next.click();
		
		String Expected_WrongPasswordAlert = "Wrong password. Try again or click Forgot password to reset it.";
		String Actual_WrongPasswordAlert = Wrong_Password_Error.getText();
		Assert.assertEquals(Actual_WrongPasswordAlert, Expected_WrongPasswordAlert);
		
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", Login_Button);
//		    	
		Thread.sleep(3000);
		return new HomePage();
	}
	
	
}
