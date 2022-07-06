package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessSession {
private WebDriver driver;
	
	public UserAccessSession() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[10]/a")
	private WebElement session;
	
	@FindBy(xpath="//*[@id=\"data-table-session_length\"]/label/select")
	private WebElement show;
	
	@FindBy(xpath="//*[@id=\"data-table-session_length\"]/label/select")
	private WebElement inputSearch;
	
	@FindBy(xpath="//*[@id=\"btnSearch\"]/i")
	private WebElement search;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div[1]/div/a/i")
	private WebElement reload;
	
	@FindBy(xpath="//*[@id=\"data-table-session_next\"]/a")
	private WebElement next;
	
	@FindBy(xpath="//*[@id=\"data-table-session_previous\"]/a")
	private WebElement previous;
	
	@FindBy(css = "#data-table-session > tbody > tr > td:nth-child(5) > a")
	private WebElement trash;
	
	public void checkSession() {
		session.click();
		Select entries = new Select(show);
		entries.selectByValue("50");
		inputSearch.sendKeys("admindika");
		search.click();
//		next.click();
//		previous.click();
		tunggu(3);
		reload.click();
		driver.navigate().refresh();
	}
	public void trashSession() {
		trash.click();
		tunggu(3);
		driver.switchTo().alert().dismiss();
		tunggu(2);
		
		trash.click();
		tunggu(3);
		driver.switchTo().alert().accept();
	}
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
