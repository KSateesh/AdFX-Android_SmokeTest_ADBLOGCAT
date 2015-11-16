package com.twc.SmokeTestCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twc.General.Swipe;
import com.twc.General.app_Kill_Relaunch;
import com.twc.driver.Driver;

public class SmokeTest_AD_C333180_10Day extends Driver{


	@SuppressWarnings("unused")
	public void verify_adpresent_onextendedTenday_page() throws Exception
	{
		
		
		//app kill and relaunch the app
//		app_Kill_Relaunch.Kill_realaunch();

		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
	
		//To get the dimensions of the screen
				Dimension dimensions = Ad.manage().window().getSize();
				//System.out.println("dimensions :: "+dimensions); //2
      
				System.out.println("Searching for 10Day section");
				
		for (int i = 0; i < dimensions.getHeight(); i++) 
		{
			
			WebElement tenday = null;

			try {
//				tenday = Ad.findElementById("com.weather.Weather:id/tenday_title");
				tenday = Ad.findElementByName("10 Day");

			 } catch (Exception e) {
				// System.out.println(e);	
			 }
			
			if(tenday!= null && tenday.isDisplayed())	
			{ 
				System.out.println("10Day page is displayed");
				
				System.out.println("Searching for EXTENDED FORECAST / WEEKEND FORCAST button"); //and tapping on EXTENDED FORECAST / WEEKEND FORCAST button
				
				WebElement tenDayExtended=null;

				try{

					tenDayExtended = Ad.findElementById("com.weather.Weather:id/more");
			
				}catch(Exception e){
					
					//Ad.swipe(0,scrollStart,0,scrollEnd,2000);
				}
				if(tenDayExtended!=null && tenDayExtended.isDisplayed())	
				{	
					System.out.println("EXTENDED FORECAST / WEEKEND FORCAST button is displayed and tapping on the same");
					
					try{

				Ad.findElementById("com.weather.Weather:id/more").click();
				
				System.out.println("In try block");
				
				MobileElement AdEle =(MobileElement) Ad.findElementById("com.weather.Weather:id/ad_view_holder");

				WebDriverWait wait1 = new WebDriverWait(Ad, 4);
				
				wait1.until(ExpectedConditions.visibilityOf(AdEle));
				
				if(AdEle.isDisplayed())
				{
					System.out.println("Ad is displayed on 10Day_Extended page");
					Thread.sleep(6000);
					
					// Clicking back button
					Ad.findElement(By.id("android:id/home")).click();
					
				}break;
					}catch(Exception e){
						Ad.findElementByName("WEEKEND FORECAST").click();
//						Ad.findElementById("com.weather.Weather:id/more").click();
						System.out.println("In catch block");
						MobileElement AdEle =(MobileElement) Ad.findElementById("com.weather.Weather:id/ad_view_holder");

						WebDriverWait wait1 = new WebDriverWait(Ad, 4);
						
						wait1.until(ExpectedConditions.visibilityOf(AdEle));
						
						if(AdEle.isDisplayed())
						{
							System.out.println("Ad is displayed on 10Day_Extended page");
							Thread.sleep(6000);
							
							// Clicking back button
							Ad.findElement(By.id("android:id/home")).click();
							
						}break;
					}
			    }else
				{
			    	System.out.println("10Day_Extended is not displayed and scrolling down");

			    	Ad.swipe(0,1800,0,20,2000);
				}


			}else
			{
				System.out.println("10Day section is not present and scroll down");
				Swipe.swipe();
			}
		}

		}

	}


