package com.juaracoding.magang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessFormAddSchedule {

	private WebDriver driver;
	
	public UserAccessFormAddSchedule() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator 
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/a/span")
	private WebElement setup;
	
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/ul/li[1]/a")
	private WebElement addSchedule;
	
	@FindBy (id="datepicker-autoClose")
	private WebElement trainingDate;
	
	@FindBy (name="training_time")
	private WebElement trainingTime;
	
	@FindBy (name="trainer_code")
	private WebElement trainerName;
	
	@FindBy (name="product_name")
	private WebElement productName;
	
	@FindBy (name="quota_training")
	private WebElement quotaTrain;
	
	@FindBy (name="link_training")
	private WebElement linkTrain;
	
	//Locator Pilih
	@FindBy (css="#content > form > div > div.col-lg-8.ui-sortable > div > div.panel-body > table > tbody > tr:nth-child(1) > td:nth-child(3) > div > label")
	private WebElement pilihModul;
	
	@FindBy (css="#content > form > div > div.col-lg-12.ui-sortable > div > div.panel-body > table > tbody > tr:nth-child(1) > td:nth-child(5) > div > label")
//	@FindBy (id="cssRadio1")
	private WebElement pilihRuang;
	
	@FindBy (xpath="//*[@id=\"content\"]/form/div/div[4]/button")
	private WebElement save;
	
	@FindBy (xpath="//*[@id=\"content\"]/form/div/div[1]/div/div[1]/div/a/i")
	private WebElement collapseForm;
	
	@FindBy (xpath="//*[@id=\"content\"]/form/div/div[2]/div/div[1]/div/a/i")
	private WebElement collapseModul;
	
	@FindBy (xpath="//*[@id=\"content\"]/form/div/div[3]/div/div[1]/div/a/i")
	private WebElement collapseRuang;
	
	public void formSchedule(String quota) {
		setup.click();
		addSchedule.click();
		trainingDate.sendKeys("2022-07-15");
//		Select time = new Select(trainingTime);
//		time.selectByValue("12:05");
		trainingTime.sendKeys("11:50 AM");
		tunggu(3);
		
		Select trainer = new Select(trainerName);
		trainer.selectByValue("D6191615");
		tunggu(3);
		Select product = new Select(productName);
		product.selectByValue("BNI");
		tunggu(3);
		quotaTrain.sendKeys("aaaaaa");
		tunggu(3);
		quotaTrain.sendKeys(quota);
		linkTrain.sendKeys("www.sqa.com");
		tunggu(2);
	}
	
	public void ceklisData() {
		pilihModul.click();
		tunggu(2);
		collapseForm.click();
		collapseModul.click();
		tunggu(2);
		pilihRuang.click();
		collapseRuang.click();
		save.click();
		
	}
	private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
