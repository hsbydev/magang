package com.juaracoding.magang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessTrainingResult {

	private WebDriver driver;
	
	public  UserAccessTrainingResult() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[5]/a")
	private WebElement bucket;
	
	@FindBy (css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(2) > a")
	private WebElement trainingR;
	
	@FindBy (css="#data-table-default_filter > label > input")
	private WebElement search;
	
	@FindBy (css="#data-table-default > tbody > tr.odd > td.sorting_1")
	private WebElement plus;
	
	@FindBy(css="#data-table-default > tbody > tr.child > td > ul > li > span.dtr-data > a > i")
	private WebElement mata;
	
	//Aksi Result
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/div[2]/div[1]/a[2]")
	private WebElement aksi;
	
	@FindBy(css="#content > div > div:nth-child(2) > div > div.panel-body > div.btn-group.m-r-5.m-b-5.show > ul > li:nth-child(1) > a")
	private WebElement update;
	
	@FindBy(xpath="//*[@id=\"modalParticipant\"]/div/div/div[3]/a")
	private WebElement close;
	
	@FindBy(xpath="//*[@id=\"modalParticipant3\"]/div/div/div[3]/a")
	private WebElement xx;
	
	@FindBy(css="#content > div > div:nth-child(2) > div > div.panel-body > div.btn-group.m-r-5.m-b-5.show > ul > li:nth-child(2) > a")
	private WebElement reschedule;
	
	@FindBy(css="#content > div > div:nth-child(2) > div > div.panel-body > div.btn-group.m-r-5.m-b-5.show > ul > li:nth-child(3) > a")
	private WebElement selesai;
	
	public void checkTraining() {
		bucket.click();
		trainingR.click();
		search.sendKeys("Jumat");
		Select entries = new Select(driver.findElement(By.cssSelector("#data-table-default_length > label > select")));
		entries.selectByValue("100");
		tunggu(2);
		plus.click();
		mata.click();
	}
	
	public void updateHasil() {
		aksi.click();
//		tunggu(2);
//		update.click();
//		close.click();
//		tunggu(2);
//		aksi.click();
//		reschedule.click();
//		tunggu(2);
//		xx.click();
//		aksi.click();
//		selesai.click();
		driver.navigate().refresh();
		
	}
	private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
