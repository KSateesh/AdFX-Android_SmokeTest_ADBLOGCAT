package com.twc.SmokeTestCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twc.General.app_Kill_Relaunch;
import com.twc.driver.Driver;

public class SmokeTest_AD_C333176_Map extends Driver{

	@SuppressWarnings("unused")
	public void verify_adpresent_onextendedMap_page() throws Exception
	{
		
		//app kill and relaunch the app
		app_Kill_Relaunch.Kill_realaunch();

		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");

		MobileElement ele = (MobileElement) Ad.findElementById("com.weather.Weather:id/temperature");

		WebDriverWait wait = new WebDriverWait(Ad, 4);

		wait.until(ExpectedConditions.visibilityOf(ele));

		Dimension dimensions = Ad.manage().window().getSize();
		// System.out.println("dimensions :: "+dimensions);
		int scrollStart = 2300;
		int scrollEnd = 50;
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);
		Ad.swipe(0,scrollStart,0,scrollEnd,2000);

		for (int i=0; i<dimensions.getHeight(); i++) 
		{
			
			if(Ad.findElementById("com.weather.Weather:id/hurricane_central_module_title").isDisplayed())
			{
				if(!Ad.findElementById("com.weather.Weather:id/hurricane_central_module_title").isDisplayed());
				{
				System.out.println("Map element is not present");
				}
				
				System.out.println("Map page is displyaed and tapping on Map button");
				
				Ad.findElementById("com.weather.Weather:id/map_module_thumbnail").click();
				
				MobileElement AdEle =(MobileElement)Ad.findElementById("com.weather.Weather:id/ad_view_holder"); //csAd640 //com.weather.Weather:id/ad_view_holder

				WebDriverWait wait1 = new WebDriverWait(Ad, 4);
				wait1.until(ExpectedConditions.visibilityOf(AdEle));
				
				if(AdEle.isDisplayed())
				{
					Thread.sleep(6000);
					System.out.println("Ad present on Extended Map page");
					// Clicking back button
					Ad.findElement(By.id("android:id/home")).click();
					Thread.sleep(6000);
				}break;

			}else
			{
				System.out.println("Map element is not present");
				Ad.swipe(0,scrollStart,0,scrollEnd,2000);
				
			}
		}
	}

}
