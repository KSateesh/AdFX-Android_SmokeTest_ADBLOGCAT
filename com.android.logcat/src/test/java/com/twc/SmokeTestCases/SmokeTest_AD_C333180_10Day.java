package com.twc.SmokeTestCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twc.General.app_Kill_Relaunch;
import com.twc.driver.Driver;

public class SmokeTest_AD_C333180_10Day extends Driver{


	@SuppressWarnings("unused")
	public void verify_adpresent_onextendedTendays_page() throws Exception
	{
		
		
		//app kill and relaunch the app
		app_Kill_Relaunch.Kill_realaunch();

		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		
		
		MobileElement ele = (MobileElement) Ad.findElementById("com.weather.Weather:id/temperature");

		WebDriverWait wait = new WebDriverWait(Ad, 4);
		
		wait.until(ExpectedConditions.visibilityOf(ele));

		
		Thread.sleep(6000);
		Dimension dimensions = Ad.manage().window().getSize();
		//System.out.println("dimensions :: "+dimensions);
     	int scrollStart =2300;
		int scrollEnd =50;
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);
      
		for (int i = 0; i < dimensions.getHeight(); i++) 
		{
			if(Ad.findElementById("com.weather.Weather:id/tenday_title").isDisplayed())	
			{ 
				System.out.println("10Day page is displayed and tapping on EXTENDED FORECAST / WEEKEND FORCAST button");
				
				System.out.println("Extended Present");
				try{
					
				Ad.findElement(By.id("com.weather.Weather:id/more")).click();
				}catch(NoSuchElementException e)
				{
					Ad.findElement(By.name("WEEKEND FORECAST")).click();
				}


				MobileElement AdEle =(MobileElement) Ad.findElementById("com.weather.Weather:id/ad_view_holder");

				WebDriverWait wait1 = new WebDriverWait(Ad, 4);
				wait1.until(ExpectedConditions.visibilityOf(AdEle));
				
				if(AdEle.isDisplayed())
				{
					System.out.println("Ad present on Extended 10 Days page");
					Thread.sleep(6000);
					
					// Clicking back button
					Ad.findElement(By.id("android:id/home")).click();
					
				}break;

			}else
			{
				System.out.println("10Day section is not present");
//				System.out.println("Scrolling "+i+" time");
				Ad.swipe(0,scrollStart,0,scrollEnd,2000);
			}
		}

		}

	}


