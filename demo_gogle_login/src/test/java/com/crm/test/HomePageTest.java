package com.crm.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestPages.HomePage;
import com.crm.qa.TestPages.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	public static TestUtil testUtil;	
	public static LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
//	@Test(priority=1,description="Goto Starred Link")
//	public void GotoLink() throws Exception
//	{
//		homePage.GoInMenus();
//	}
//	
//	@Test(priority=2,description="Searching mail here by name")
//	public void SearchFunctionality() throws Exception
//	{
//		homePage.Searchfunction();
//	}
//	@Test(priority=3,description="Match Static text Program Policies")
//	public void MatchTextTest() 
//	{
//		homePage.matchText();
//	}
	@Test(priority=1,description="Match Logo of Google")
	public void MatchLogo() throws Exception 
	{
		homePage.matchLogo();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}