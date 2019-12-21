package com.crm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.TestPages.HomePage;
import com.crm.qa.TestPages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1,description="Testing Login functionality with valid details Login")
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2, description="Testing Login functionality with invalid details")
	public void NegativeLoginTest() throws Exception 
	{
		homePage = loginPage.login(prop.getProperty("InvalidUsername"), prop.getProperty("InvalidPassword"));
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
