package com.juaracoding.magang.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessLogin {

	private WebDriver driver;
	
	public UserAccessLogin() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "username")
	private WebElement inputUname;
	
	@FindBy (name = "password")
	private WebElement inputPassword;
	
	@FindBy (css = "#page-container > div > div.right-content > div.login-content > form > div.login-buttons > button")
	private WebElement btnLogin;
	
	@FindBy (css = "#page-container > div > div.right-content > div.login-content > div")
	private WebElement txtMessageError;
	
	@FindBy (css="#content > h1")
	private WebElement txtWelcome;
	//
	public void signIn(String uname, String password) {
		inputUname.sendKeys(uname);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public static void tunggu (int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
	public String getMessageErrorLogin() {
		return txtMessageError.getText();
	}
	
}
