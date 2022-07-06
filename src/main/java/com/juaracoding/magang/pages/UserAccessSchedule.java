package com.juaracoding.magang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessSchedule {

	private WebDriver driver;
	
	public UserAccessSchedule() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator daftar
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[5]/a")
	private WebElement bucket;
	
	@FindBy (css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(1) > a")
	private WebElement schedule;
	
	@FindBy (css="#content > div > div.col-lg-12.m-b-5 > a")
	private WebElement lihatDaftar;
	
	@FindBy (css="#data-table-default_length > label > select")
	private WebElement show;
	
	@FindBy (css="#data-table-default_filter > label > input")
	private WebElement search;
	
	@FindBy(css="#data-table-default > tbody > tr.odd > td.sorting_1")
	private WebElement plus;
	
	@FindBy (xpath="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li[5]/span[2]/a/i")//(css="#data-table-default > tbody > tr.child > td > ul > li > span.dtr-data > a > i")
	private WebElement edit;
	
	@FindBy(xpath="//*[@id=\"modalEdit\"]/div/div/div[1]/button")
	private WebElement x;
	
	//Locator detail
	@FindBy(css="#calendar > div.fc-toolbar.fc-header-toolbar > div.fc-left > div > button.fc-agendaWeek-button.fc-button.fc-state-default")
	private WebElement week;
	
	@FindBy(css="#calendar > div.fc-toolbar.fc-header-toolbar > div.fc-left > div > button.fc-agendaDay-button.fc-button.fc-state-default.fc-corner-right")
	private WebElement day;
	
	@FindBy(xpath="//*[@id=\"calendar\"]/div[1]/div[1]/div/button[1]")
	private WebElement month;
	
	@FindBy(xpath="//*[@id=\"calendar\"]/div[1]/div[2]/div/button[3]/span")
	private WebElement next;
	//#calendar > div.fc-toolbar.fc-header-toolbar > div.fc-right > div > button.fc-next-button.fc-button.fc-state-default.fc-corner-right.fc-state-hover > span
	
	@FindBy(xpath="//*[@id=\"calendar\"]/div[1]/div[2]/div/button[1]")
	private WebElement previous;
	
	@FindBy(xpath="//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[2]/div[1]/table/tbody/tr/td[6]")
	private WebElement pilihSchedule;
	
	@FindBy(css="#content > div > div:nth-child(2) > div > a.btn.btn-success.btn-primary-without-border")
	private WebElement tambah;
	
	@FindBy(xpath="//*[@id=\"modalSchedule2\"]/div/div/div[1]/button")
	private WebElement cancel;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[3]/div/div[2]/div/table/tbody/tr[12]/td[1]/a")
	private WebElement detail;
	
	@FindBy(css="#data-table-default > tbody > tr.odd > td.sorting_1")
	private WebElement aksip;
	
	public void lihatList() {
		bucket.click();
		schedule.click();
		tunggu(2);
		lihatDaftar.click();
		Select entries = new Select(driver.findElement(By.cssSelector("#data-table-default_length > label > select")));
		entries.selectByValue("100");
		tunggu(3);
		entries.selectByValue("10");
		search.sendKeys("Jumat");
		plus.click();
		tunggu(2);
//		edit.click();
//		tunggu(2);
//		x.click();
		driver.navigate().back();	
		
	}
	
	public void lihatDetail() {
		week.click();
		tunggu(3);
		day.click();
		tunggu(3);
		month.click();
		next.click();
		tunggu(2);
		previous.click();
		pilihSchedule.click();
		tambah.click();
		driver.navigate().back();
//		cancel.click();
//		detail.click();
//		aksip.click();
	}
	private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
