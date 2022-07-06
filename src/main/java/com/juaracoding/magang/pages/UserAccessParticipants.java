package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessParticipants {

	private WebDriver driver;
	
	public UserAccessParticipants(){
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	//Locator
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/a/span")
	private WebElement setup;
	
	@FindBy (xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[4]/ul/li[3]/a")
	private WebElement participants;
	
	@FindBy (xpath="//*[@id=\"content\"]/div/div[1]/a")
	private WebElement addNew;
	
	@FindBy(xpath="//*[@id=\"data-table-default\"]/tbody/tr[1]/td[1]")
	private WebElement plus;
	
	@FindBy(xpath="//*[@id=\"data-table-default\"]/tbody/tr[2]/td/ul/li/span[2]/a/i")
	private WebElement mata;
	//Locator Form
	@FindBy (xpath="//*[@id=\"showAddForm\"]/div/div/div[2]/form/fieldset/div[1]/div/input")
	private WebElement name;
	
	@FindBy (xpath="//*[@id=\"showAddForm\"]/div/div/div[2]/form/fieldset/div[2]/div/input")
	private WebElement mobilePhone;
	
	@FindBy (xpath="//*[@id=\"showAddForm\"]/div/div/div[2]/form/fieldset/div[3]/div/input")
	private WebElement productForm;
	
	@FindBy (xpath="//*[@id=\"showAddForm\"]/div/div/div[2]/form/fieldset/div[4]/div/select")
	private WebElement groupType;
	
	@FindBy (xpath="//*[@id=\"showAddForm\"]/div/div/div[2]/form/fieldset/button")
	private WebElement save;
	
	@FindBy(css="body > div > h4")
	private WebElement txtPart;
	
	public void formParticipants() {
		setup.click();
		participants.click();
		tunggu(2);
		plus.click();
		mata.click();
	}
	
	public void inputParticipants(String namapar ,String mobilephone , String product) {
		addNew.click();
		tunggu(2);
		name.sendKeys(namapar);
		mobilePhone.sendKeys(mobilephone);
		productForm.sendKeys(product);
		Select group = new Select(groupType);
		group.selectByValue("Reactive");
		tunggu(2);
		save.click();
	}
	
	public String getTxtParti() {
		return txtPart.getText();
	}
	
	private void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
