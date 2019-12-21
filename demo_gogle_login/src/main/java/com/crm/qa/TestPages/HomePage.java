package com.crm.qa.TestPages;

import static org.testng.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.TestPages.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[@title=\"Starred\"]")
	WebElement GoToStarred;
	
	@FindBy(xpath="//input[@class=\"gb_bf\"]")
	WebElement Search;
	@FindBy(xpath="//img[@class=\"gb_ua\"]")
	WebElement Logo_Gmail;
	@FindBy(xpath="//a[contains(text(),'Program Policies')]")
	WebElement StaticText;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public void GoInMenus() 
	{
		GoToStarred.click();
	}
	
	public void Searchfunction() throws Exception
	
	{
		Thread.sleep(3000);
		Search.sendKeys("ABC");
		Search.sendKeys(Keys.RETURN);
	}
	
	public void matchText() 
	{
		String Actual_text = StaticText.getText();
		String Expected_text = "Program Policies";
		Assert.assertEquals(Actual_text, Expected_text);
	}
	
	public void matchLogo() throws Exception
	{
		
		BufferedImage ExpectedImage = ImageIO.read(new File("C://Users/LENOVO/Desktop/Assignment-1/Demo/src/main/java/TestData/Logo_Gmail.png"));
		
		Thread.sleep(6000);
		Screenshot LogoScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, Logo_Gmail);
		Thread.sleep(2000);
		BufferedImage ActualImage = LogoScreenShot.getImage();
		Thread.sleep(1000);		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff difference = imgDiff.makeDiff(ExpectedImage, ActualImage);
		Thread.sleep(1000);
		if(difference.hasDiff()==true) 
		{
			Assert.assertEquals(true, true);
		}
		else 
		{
			Assert.assertEquals(false, true);
		}
		
		
	}
	

}
