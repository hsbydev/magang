package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessBarcodeRegistrationInvalid {

private WebDriver driver;
	
	public UserAccessBarcodeRegistrationInvalid() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator
	@FindBy (xpath ="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[6]/a")
	private WebElement barcodeRegist;
	
	@FindBy (id ="barcode")
	private WebElement inputId;
	
	@FindBy(xpath ="//*[@id=\"form\"]/fieldset/button")
	private WebElement submit;
	
	public void registBarcodeInvalid(String barcodefail) {
		barcodeRegist.click();
		tunggu(3);
		inputId.sendKeys(barcodefail);
		tunggu(3);
		submit.click();
		driver.navigate().back();
		
	}
	private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
