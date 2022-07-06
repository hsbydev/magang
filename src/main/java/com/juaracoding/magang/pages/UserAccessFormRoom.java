package com.juaracoding.magang.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessFormRoom {
	
private WebDriver driver;
	
	public UserAccessFormRoom() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator New Room
	@FindBy (xpath ="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[3]/a")
	private WebElement master;
	
	@FindBy (xpath ="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[3]/ul/li[2]/a")
	private WebElement btnRoom;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div/div[1]/div/a")
	private WebElement tambahRuangan;
	
	@FindBy (name ="nama_ruangan")
	private WebElement namaRuangan;
	
	@FindBy (name ="lokasi_ruangan")
	private WebElement lokasiRuangan;
	
	@FindBy (name ="quota")
	private WebElement quota;
	
	@FindBy (xpath = "//*[@id=\"modalAdd\"]/div/div/div[2]/form/fieldset/button")
	private WebElement saveNew;
	
	//Locator Show Room
	
	@FindBy (xpath ="//*[@id=\"data-table-default_next\"]/a")
	private WebElement next;
	
	@FindBy (xpath ="//*[@id=\"data-table-default_previous\"]/a")
	private WebElement previous;
	
	@FindBy (xpath ="//*[@id=\"data-table-default_filter\"]/label/input")
	private WebElement search;
	
	@FindBy (xpath ="//*[@id=\"data-table-default\"]/tbody/tr[1]/td[1]")
	private WebElement plus;
	
	@FindBy (xpath="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a[1]/i")
	private WebElement mata; //*[@id="data-table-default"]/tbody/tr[2]/td/ul/li[2]/span[2]/a[1]
	
	@FindBy (xpath="//*[@id=\"modalDetail\"]/div/div/div[1]/button")
	private WebElement closeDetail;
	
	@FindBy (xpath ="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a[2]/i")
	private WebElement edit;
	
	@FindBy (xpath ="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a[3]/i")
	private WebElement hapus;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div/div[3]/div/div[1]/div/a[1]/i")
	private WebElement eCompress;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div/div[3]/div/div[1]/div/a[2]/i")
	private WebElement eCollapse;
	
	public void newRoom(String namaRuang , String lokRuang , String kuota) {
		master.click();
		btnRoom.click();
		tambahRuangan.click();
		namaRuangan.sendKeys(namaRuang);
		lokasiRuangan.sendKeys(lokRuang);
		quota.sendKeys(kuota);
		tunggu(3);
		saveNew.click();
	}
	
	public void formRoom() {
		next.click();
		tunggu(2);
		previous.click();
		Select entries = new Select(driver.findElement(By.xpath("//*[@id=\"data-table-default_length\"]/label/select")));
		entries.selectByValue("100");
		search.sendKeys("B");
		plus.click();
		mata.click();
		tunggu(3);
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
