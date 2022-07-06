package com.juaracoding.magang.utils;

public enum TestCases {

	T1("Testing Login Administrator"),
	T2("Testing Halaman Dashboard"),
	T3("Testing Form Module"),
	T4("Testing Form Room Invalid"),
	T5("Testing Form Room"),
	T6("Testing Form Add Schedule"),
	T7("Testing Fix Schedule"),
	T8("Testing Participants"),
	T9("Testing Barcode Registration"),
	T10("Testing Barcode Registration Invalid"),
	T11("Testing Search Data"),
	T12("Testing Schedule"),
	T13("Testing Training Result"),
	T14("Testing Laporan All View"),
	T15("Testing Session");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
}
