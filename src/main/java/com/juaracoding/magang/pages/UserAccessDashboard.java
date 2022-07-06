package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessDashboard {

	private WebDriver driver;
	
	public UserAccessDashboard() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Assign
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[3]/a")
	private WebElement btnAssign;
	
	@FindBy(xpath = "//*[@id=\"data-table-default\"]/tbody/tr[5]/td[1]")
	private WebElement btnPlus;
	
	@FindBy(xpath = "//*[@id=\"data-table-default\"]/tbody/tr[6]/td/ul/li/span[2]/a/i")
	private WebElement mata;
	
	@FindBy(id="aturpeserta")
	private WebElement aturPeserta;
	
	@FindBy(xpath="//*[@id=\"divcheck_1\"]/div/label")
	private WebElement pilihPeserta;
	
	@FindBy(id="pilihjadwal")
	private WebElement pilihJadwal;
	
	@FindBy(xpath="//*[@id=\"modalSchedule\"]/div/div/div[2]/table/tbody/tr[3]/td[3]/a")
	private WebElement pilih;//*[@id="modalSchedule"]/div/div/div[2]/table/tbody/tr[3]/td[3]/a
	//*[@id="modalSchedule"]/div/div/div[2]/table/tbody/tr[1]/td[3]/a
	
//	@FindBy(xpath="//*[@id=\"tbl_2022-07-08\"]/td/table/tbody/tr/td[6]/a")
//	private WebElement pilihTrainer;
	
	@FindBy(css="#tbl_2022-07-15 > td > table > tbody > tr:nth-child(1) > td:nth-child(6) > a")
	private WebElement pilihTrainer;
	
	//Training
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div[3]/a")
	private WebElement btnTraining;
	
	@FindBy(xpath = "//*[@id=\"data-table-default\"]/tbody/tr[2]/td[1]")
	private WebElement btnPluss;
	
	@FindBy(xpath = "//*[@id=\"data-table-default\"]/tbody/tr[3]/td/ul/li/span[2]/a/i")
	private WebElement mataa;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/div/div[3]/a")
	private WebElement btnPenerimaan;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[4]/div/div[3]/a")
	private WebElement btnSchedule;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[5]/div/div[1]/div/a[1]")
	private WebElement eCompress;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[5]/div/div[1]/div/a[2]/i")
	private WebElement reload;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[5]/div/div[1]/div/a[3]/i")
	private WebElement eCollapse;
	
	//
	public void dashBoard() {
		btnAssign.click();
		btnPlus.click();
		tunggu(2);
		mata.click();
		tunggu(3);
		aturPeserta.click();
		tunggu(2);
		pilihPeserta.click();
		pilihJadwal.click();
		tunggu(2);
		pilih.click();
		tunggu(2);
		pilihTrainer.click();
		driver.navigate().back();
		tunggu(4);
		driver.navigate().back();
		
		//
		btnTraining.click();
		//btnPluss.click();
		//mataa.click();
		tunggu(3);
		driver.navigate().back();
//		tunggu(5);
//		driver.navigate().back();
		
		//
		btnPenerimaan.click();
		driver.navigate().back();
		tunggu(5);
		btnSchedule.click();
		driver.navigate().refresh();
		tunggu(5);
	}
	//Calendar
	public void Calendar() {	
		eCompress.click();
		tunggu(3);
		eCompress.click();
		reload.click();
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
