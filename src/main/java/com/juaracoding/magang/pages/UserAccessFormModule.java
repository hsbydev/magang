package com.juaracoding.magang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessFormModule {

private WebDriver driver;
	
	public UserAccessFormModule() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
		//Locator
		@FindBy (xpath ="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[3]/a")
		private WebElement master;
		
		@FindBy (xpath ="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[3]/ul/li[1]/a")
		private WebElement btnModule;
		
		@FindBy (xpath = "//*[@id=\"content\"]/div/div[1]/div/a")
		private WebElement addNew;
		
		@FindBy (id = "modules")
		private WebElement inputModule;

		@FindBy (id = "submit")
		private WebElement saveModule;
		
		@FindBy (className = "close")
		private WebElement closeInput;
		
		@FindBy (xpath = "//*[@id=\"data-table-default_filter\"]/label/input")
		private WebElement search;
		
		@FindBy (xpath = "//*[@id=\"data-table-default\"]/tbody/tr[1]/td[1]")
		private WebElement plus;
		
		@FindBy (xpath = "//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a[1]/i")
		private WebElement mata;
		
		@FindBy (xpath="//*[@id=\"modalDetail\"]/div/div/div[1]/button")
		private WebElement closeDetail;
		
		@FindBy (xpath ="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a[2]/i")
		private WebElement edit;
		
		@FindBy (xpath ="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a[3]/i")
		private WebElement hapus;
		
		@FindBy (xpath ="//*[@id=\"data-table-default_next\"]/a")
		private WebElement next;
		
		@FindBy (xpath ="//*[@id=\"data-table-default_previous\"]/a")
		private WebElement previous;
		
		@FindBy (xpath ="//*[@id=\"content\"]/div/div[3]/div/div[1]/div/a[1]/i")
		private WebElement eCompress;
		
		@FindBy (xpath ="//*[@id=\"content\"]/div/div[3]/div/div[1]/div/a[2]/i")
		private WebElement eCollapse;
		//
		public void newModule (String module) {
			master.click();
			btnModule.click();
			addNew.click();
			inputModule.sendKeys(module);
			tunggu(2);
			driver.navigate().refresh();
		}
		
		public void formModule(){
			next.click();
			tunggu(2);
			previous.click();
			Select entries = new Select(driver.findElement(By.xpath("//*[@id=\"data-table-default_length\"]/label/select")));
			entries.selectByValue("100");
			search.sendKeys("A");
			plus.click();
			mata.click();
			tunggu(5);
			closeDetail.click();
			tunggu(3);
			edit.click();
			tunggu(2);
			driver.navigate().refresh();
			tunggu(2);
			plus.click();
			hapus.click();
			tunggu(3);
			//Alert
			driver.switchTo( ).alert( ).dismiss();
			tunggu(2);
			hapus.click();
			driver.switchTo().alert().accept();
			eCompress.click();
			tunggu(2);
			eCompress.click();
			eCollapse.click();
				
		}

		private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
