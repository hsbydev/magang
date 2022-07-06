package com.juaracoding.magang.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.magang.driver.DriverSingleton;

public class UserAccessAllView {
private WebDriver driver;
	
	public UserAccessAllView() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[9]/a")
	private WebElement laporan;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[9]/ul/li[2]/a")
	private WebElement allView;
	
	@FindBy(css = "#content > ol > li.breadcrumb-item.active")
	private WebElement view;
	
//	public String getTxtView() {
//		return view.getText();
//	}
	@FindBy(id = "datepicker-autoClose5")
	private WebElement date;
	
	@FindBy(id = "datepicker-autoClose6")
	private WebElement date2;
	
	@FindBy(css = "#content > div > div.col-lg-12.ui-sortable > div > div.panel-body.bg-black.text-white > div > div.col-md-2 > h6")
	private WebElement filter;
	
//	public String getTxtFilter() {
//		return filter.getText();
//	}
	
	@FindBy(name = "btn_go")
	private WebElement btnGo;
	
	@FindBy(css = "#content > div > div.col-lg-12.ui-sortable > div > div.panel-body.bg-black.text-white > div > div.col-md-10 > div > form > table > tbody > tr:nth-child(1) > td:nth-child(1) > h6")
	private WebElement btnOk;
	
//	public void btnGo() {
//		
//	}
//	public String getTxtBtnOk() {
//		return btnOk.getText();
//	}
	@FindBy(css = "#content > div > div.col-lg-12.ui-sortable > div > div.panel-body.bg-black.text-white > div > div.col-md-10 > div > form > table > tbody > tr:nth-child(2) > td > label:nth-child(2) > a > i")
	private WebElement export;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(9) > a > span")
	private WebElement txtExport;
	
//	public void gotoExport() {
//		
//	}
//	public String getTxtExport() {
//		return txtExport.getText();
//	}
	@FindBy(css = "#data-table-default_filter > label > input")
	private WebElement search;
	
	@FindBy(css = "#data-table-default_filter > label")
	private WebElement txtSearch;
	
//	public String getTxtSearch() {
//		return txtSearch.getText();
//	} 
//	public void search() {
//		
//	}
	@FindBy(css = "#data-table-default_length > label > select")
	private WebElement show;
	
	@FindBy(css = "#data-table-default_length > label")
	private WebElement txShow;
	
//	public void show() {
//		
//	}
//	public String txShow() {
//		return txShow.getText();
//	}
	@FindBy(css = "#data-table-default > tbody > tr:nth-child(1) > td.sorting_1")
	private WebElement iconPlus;
	
//	public void iconPlus() {
//		
//	}
	@FindBy(css = "#data-table-default > thead > tr > th.sorting_asc")
	private WebElement ascending;
	
	@FindBy(css = "#data-table-default > thead > tr > th.sorting_desc")
	private WebElement descending;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a > span")
	private WebElement txtAscending;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(6) > a > span")
	private WebElement txtDescending;
	
//	public void gotoAscending() {
//		
//	}
//	public void gotoDescending() {
//		
//	}
//	public String getTxtAscending() {
//		return txtAscending.getText();
//	}
//	public String getTxtDescending() {
//		return txtDescending.getText();
//	}
	@FindBy(css = "#content > div > div.col-lg-12.ui-sortable > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement colapse;
	
	@FindBy(css = "#content > div > div.col-lg-12.ui-sortable > div > div.panel-body.bg-black.text-white > div > div.col-md-10 > div > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > h6")
	private WebElement txtCollapse;
	
	public void checkTanggal() {
		laporan.click();
		allView.click();
		
		date.clear();
		tunggu(2);
		date.sendKeys(Keys.chord(Keys.CONTROL+"a","2022-06-01"));
		date.sendKeys("2022-06-01");
		date.sendKeys(Keys.RETURN);
		date2.clear();
		date2.sendKeys(Keys.chord(Keys.CONTROL+"a","2022-07-01"));
		date2.sendKeys("2022-07-01");
		date2.sendKeys(Keys.RETURN);
		
		btnGo.click();
	}
	public void melihatLaporan() {	
		export.click();
		
		search.sendKeys("ADIT");
		search.sendKeys(Keys.RETURN);
		tunggu(3);
		search.clear();
		search.sendKeys(Keys.RETURN);
		
		show.sendKeys("25");
		
		//iconPlus.click();
		ascending.click();
		descending.click();
		colapse.click();
	}
//	public void gotoCollapse() {
//	
//	}
//	public String getTxtCollapse() {
//		return txtCollapse.getText();
//	}
//	
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
