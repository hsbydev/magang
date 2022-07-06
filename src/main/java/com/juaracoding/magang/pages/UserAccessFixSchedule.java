package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessFixSchedule {

	private WebDriver driver;
	
	public UserAccessFixSchedule() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator Fix
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/a/span")
	private WebElement setup;
	
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/ul/li[2]/a")
	private WebElement fixSchedule;
	
	@FindBy(css="#content > h1")
	private WebElement txtFix;
	
	public void clickFix() {
		setup.click();
		fixSchedule.click();
		tunggu(3);
	}
	public String getTxtFix() {
		return txtFix.getText();
	}
	private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
