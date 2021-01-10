package com.pharmaspectra.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pharmaspectra.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	WebDriver ldriver;
			
	// initializing the page object
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}



}


