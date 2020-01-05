package com.orangehrm.common;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	
	private static ThreadLocal<WebDriver> threadLevelStorage = new ThreadLocal<>();
	
	public static WebDriver getWebDriver(){
		
		return threadLevelStorage.get();
		
	}
	
	protected static void setWebdriver(WebDriver objdr){
		threadLevelStorage.set(objdr);
	}

}
