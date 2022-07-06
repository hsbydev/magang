package com.juaracoding.magang.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessFormRoomInvalid {

private WebDriver driver;
	
	public UserAccessFormRoomInvalid() {
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
	private WebElement kuota;
	
	@FindBy (xpath = "//*[@id=\"modalAdd\"]/div/div/div[2]/form/fieldset/button")
	private WebElement saveNew;
	
	public void newRoomFail(String namaRuang , String lokRuang , String kuotaFail) {
		master.click();
		btnRoom.click();
		tambahRuangan.click();
		namaRuangan.sendKeys(namaRuang);
		lokasiRuangan.sendKeys(lokRuang);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		kuota.sendKeys(kuotaFail);
		driver.navigate().back();
	}
}
