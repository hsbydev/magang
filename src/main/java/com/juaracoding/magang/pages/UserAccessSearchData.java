package com.juaracoding.magang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessSearchData {
	private WebDriver driver;
	
	public UserAccessSearchData (){
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator Search
	 @FindBy(xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[7]/a")
	 private WebElement searchData;
	 
	 @FindBy(css="#content > form > div > div:nth-child(2) > div > div > input")
	 private WebElement inputSearch;
	 
	 @FindBy(css="#content > form > div > div:nth-child(2) > div > div > div > button")
	 private WebElement search;
	 
	 //Locator Detail
	 @FindBy(xpath="//*[@id=\"content\"]/form/div/div[3]/div/div[1]/div/a[1]/i")
	 private WebElement eCompress;
	 
	 @FindBy (css="#content > form > div > div.col-lg-12.ui-sortable > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning > i")
	 private WebElement eCollapse;
	 
	 @FindBy (css="#data-table-default_next > a")
	 private WebElement next;
	 
	 @FindBy (css="#data-table-default_previous > a")
	 private WebElement previous;
	 
	 @FindBy(css="#data-table-default > tbody > tr:nth-child(1) > td.sorting_1")
	 private WebElement plus;
	 
//	 @FindBy(css="#data-table-default > tbody > tr.child > td > ul > li:nth-child(3) > span.dtr-data > a > i")
	 @FindBy(xpath="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li[3]/span[2]/a/i")
	 private WebElement mata;
	 
	 @FindBy(css="#content > h1 > a")
	 private WebElement aturUlang;
	 
	 @FindBy(xpath="//*[@id=\"modalSchedule\"]/div/div/div[1]/button")
	 private WebElement cancel;
	 
	 public void searchPeserta() {
		 searchData.click();
		 inputSearch.sendKeys("elva");
		 search.click();
		 tunggu(2);
	 }
	 
	 public void detailPeserta() {
		 next.click();
		 tunggu(2);
		 previous.click();
		 Select entries = new Select(driver.findElement(By.xpath("//*[@id=\"data-table-default_length\"]/label/select")));
		 entries.selectByValue("50");
		 eCompress.click();
		 tunggu(2);
		 eCompress.click();
		 eCollapse.click();
		 tunggu(2);
		 eCollapse.click();
		 plus.click();
//		 mata.click();
//		 tunggu (2);
//		 aturUlang.click();
//		 cancel.click();
//		 driver.navigate().back();
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
