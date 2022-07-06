package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessBarcodeRegistration {

	private WebDriver driver;
	
	public UserAccessBarcodeRegistration() {
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
	
	@FindBy(xpath ="//*[@id=\"form\"]/fieldset/a")
	private WebElement clearId;
	
	@FindBy(xpath ="//*[@id=\"myBtn\"]")
	private WebElement btn1;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div[1]/div[2]/div[2]/div[2]/table/tbody/tr[4]/td[3]/a/i")
	private WebElement hapusBtn;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div[1]/div[2]/div[2]/div[2]/table/tbody/tr[4]/td[1]/a")
	private WebElement clearBtn;
	
	@FindBy (xpath ="/html/body/div[3]/div/div[1]/div[1]/div/div[1]/div/a/i")
	private WebElement collapseHasil;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div[1]/div[2]/div[2]/div[1]/div/a/i")
	private WebElement collapseBtn;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div[1]/div[2]/div[1]/div[1]/div/a/i")
	private WebElement collapseRegist;
	
	public void tesTombol() {
		barcodeRegist.click();
		tunggu(2);
		btn1.click();
		tunggu(4);
		hapusBtn.click();
		tunggu(3);
		btn1.click();
		tunggu(2);
		clearBtn.click();
	}
	
	public void inputRegis(String barcode) {
		inputId.sendKeys(barcode);
		tunggu(2);
		clearId.click();
		inputId.sendKeys(barcode);
		tunggu(3);
		submit.click();
		collapseHasil.click();
		collapseBtn.click();
		collapseRegist.click();
		tunggu(4);
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
