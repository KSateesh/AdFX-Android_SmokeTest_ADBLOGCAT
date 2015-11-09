package com.twc.AD_TestSuite;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.twc.AppiumAutoStart.Capabilities_android;
import com.twc.General.DeleteFile;
import com.twc.General.File_Exist;
import com.twc.General.setAddress_Location;
import com.twc.General.toKnowBuildVersion;
import com.twc.SmokeTestCases.SmokeTest_AD_C333175_Hourly;
import com.twc.SmokeTestCases.SmokeTest_AD_C333176_Map;
import com.twc.SmokeTestCases.SmokeTest_AD_C333177_News;
import com.twc.SmokeTestCases.SmokeTest_AD_C333179_Verify_PullToRefresh;
import com.twc.SmokeTestCases.SmokeTest_AD_C333180_10Day;
import com.twc.driver.Driver;

import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


public class Smoke_Test extends Driver{

	
	@Test
	public void Capabilites() throws ParseException, IOException, InterruptedException
  {
		 //Calling the capabilities method
		Capabilities_android cap = new Capabilities_android();
	    cap.dcap();
	
	    //Calling the method to know build version of the app class
//	toKnowBuildVersion buildVersion = new toKnowBuildVersion();
//		buildVersion.moreOptionsClick();
		
		//Calling the method to know build version of the app class
//		setAddress_Location sa = new setAddress_Location();
//			sa.setLocation();

	//Delete the log existed file
	DeleteFile DF = new DeleteFile();
	File_Exist FE = new File_Exist();
	
	if(FE.fileexist()) {
		DF.deleteFile();

	} else {
		System.out.println("File not exist");
	}
	
	
  }
	
	//Pull to Refresh
	@Test (priority=1, threadPoolSize = 1,invocationCount = 1)
	public void AND_PulltoRefresh() throws ParseException, IOException, InterruptedException
	{
	
		SmokeTest_AD_C333179_Verify_PullToRefresh pulltorefresh = new SmokeTest_AD_C333179_Verify_PullToRefresh();
		pulltorefresh.Verify_PulltoRefresh();
	}
	
	//Hourly Ad
	@Test(priority=2, threadPoolSize = 1,invocationCount = 1 )
	public void c334146_Verify_adon_HourlyExtended_page() throws Exception {
		SmokeTest_AD_C333175_Hourly c334146 = new SmokeTest_AD_C333175_Hourly();
		c334146.verify_adpresent_onextendedHourly_page();

	}
	
	//10 Day Ad
	@Test(priority=3, threadPoolSize = 1,invocationCount = 1)
	public void c334151_Verify_adon_10DaysExtended_page() throws Exception {

		SmokeTest_AD_C333180_10Day c334151 = new SmokeTest_AD_C333180_10Day();
		c334151.verify_adpresent_onextendedTendays_page();

	}
	

	//	Maps page Ad
	@Test(priority=4, threadPoolSize = 1,invocationCount = 1)
	public void c334147_Verify_adon_MapsExtended_page() throws Exception {

		SmokeTest_AD_C333176_Map c334147 = new SmokeTest_AD_C333176_Map();
		c334147.verify_adpresent_onextendedMap_page();

	}
	
	//News Page Ad	
	@Test(priority=5, threadPoolSize = 1,invocationCount = 1)
	public void c334148_Verify_adon_NewsExtended_page() throws Exception {

		SmokeTest_AD_C333177_News c334148 = new SmokeTest_AD_C333177_News();
		c334148.verify_adpresent_onextendedMap_page();

	}
}
