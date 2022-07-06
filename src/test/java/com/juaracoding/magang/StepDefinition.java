package com.juaracoding.magang;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.magang.config.AutomationFrameWorkConfig;
import com.juaracoding.magang.driver.DriverSingleton;
import com.juaracoding.magang.pages.UserAccessAllView;
import com.juaracoding.magang.pages.UserAccessBarcodeRegistration;
import com.juaracoding.magang.pages.UserAccessBarcodeRegistrationInvalid;
import com.juaracoding.magang.pages.UserAccessDashboard;
import com.juaracoding.magang.pages.UserAccessFixSchedule;
import com.juaracoding.magang.pages.UserAccessFormAddSchedule;
import com.juaracoding.magang.pages.UserAccessFormModule;
import com.juaracoding.magang.pages.UserAccessFormRoom;
import com.juaracoding.magang.pages.UserAccessFormRoomInvalid;
import com.juaracoding.magang.pages.UserAccessLogin;
import com.juaracoding.magang.pages.UserAccessParticipants;
import com.juaracoding.magang.pages.UserAccessSchedule;
import com.juaracoding.magang.pages.UserAccessSearchData;
import com.juaracoding.magang.pages.UserAccessSession;
import com.juaracoding.magang.pages.UserAccessTrainingResult;
import com.juaracoding.magang.utils.ConfigurationProperties;
import com.juaracoding.magang.utils.Constants;
import com.juaracoding.magang.utils.TestCases;
import com.juaracoding.magang.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
//import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameWorkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private UserAccessLogin userAccessLogin;
	private UserAccessDashboard userAccessDashboard;
	private UserAccessFormModule userAccessFormModule;
	private UserAccessFormRoomInvalid userAccessFormRoomInvalid;
	private UserAccessFormRoom userAccessFormRoom;
	private UserAccessFormAddSchedule userAccessFormAddSchedule;
	private UserAccessFixSchedule userAccessFixSchedule;
	private UserAccessParticipants userAccessParticipants;
	private UserAccessBarcodeRegistrationInvalid userAccessBarcodeRegistrationInvalid;
	private UserAccessBarcodeRegistration userAccessBarcodeRegistration;
	private UserAccessSearchData userAccessSearchData;
	private UserAccessSchedule userAccessSchedule;
	private UserAccessTrainingResult userAccessTrainingResult;
	private UserAccessAllView userAccessAllView;
	private UserAccessSession userAccessSession;
	//Tambahan di pages
	static ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/ReportTest.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		userAccessLogin = new UserAccessLogin();
		userAccessDashboard = new UserAccessDashboard();
		userAccessFormModule = new UserAccessFormModule();
		userAccessFormRoomInvalid = new UserAccessFormRoomInvalid();
		userAccessFormRoom = new UserAccessFormRoom();
		userAccessFormAddSchedule = new UserAccessFormAddSchedule();
		userAccessFixSchedule = new UserAccessFixSchedule();
		userAccessParticipants = new UserAccessParticipants();
		userAccessBarcodeRegistrationInvalid = new UserAccessBarcodeRegistrationInvalid();
		userAccessBarcodeRegistration = new UserAccessBarcodeRegistration();
		userAccessSearchData = new UserAccessSearchData();
		userAccessSchedule = new UserAccessSchedule();
		userAccessTrainingResult = new UserAccessTrainingResult();
		userAccessAllView = new UserAccessAllView();
		userAccessSession = new UserAccessSession();
		
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			String screenshotPath = Utils.getScreenShot(driver, scenario.getName().replace(" ","_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:\n"+
					extentTest.addScreenCapture(screenshotPath));
		}
	}
	@After
	public static void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
	}
//	@AfterAll
//	public static void quitDriver() {
//		tunggu(5);
//		driver.quit();
//	}
	// A.Login
	@Given ("User mengakses url")
	public void user_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "User mengakses url"+Constants.URL);
	}
	
	@When("User Login dengan username dan password")
	public void user_Login_dengan_username_dan_password() {
		userAccessLogin.signIn(configurationProperties.getUname(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User Login dengan username dan password");
	}
	
	@Then("User berhasil login")
	public void user_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcome(),userAccessLogin.getTxtWelcome());
		extentTest.log(LogStatus.PASS, "User berhasil login");
	}
	// B.Dashboard
	
	@Given ("User mengakses dashboard")
	public void user_mengakses_dashboard() {
		userAccessDashboard.dashBoard();
		extentTest.log(LogStatus.PASS, "User mengakses dashboard");
	}
	
	@When("User melihat calendar")
	public void user_melihat_calendar() {
		userAccessDashboard.Calendar();
		extentTest.log(LogStatus.PASS, "User melihat calendar");
	}
	
	// C.Form Module
	
	@Given ("User membuat module baru")
	public void user_membuat_module_baru() {
		userAccessFormModule.newModule(configurationProperties.getModule());        
		extentTest.log(LogStatus.PASS, "User membuat module baru");
	}
	
	@When ("User melihat daftar module")
	public void user_melihat_daftar_module() {
		userAccessFormModule.formModule();
		extentTest.log(LogStatus.PASS, "User melihat daftar module");
	}
	
	// D.Form Room Invalid
	
	@Given ("User membuat room baru invalid")
	public void user_membuat_room_baru_invalid() {
		userAccessFormRoomInvalid.newRoomFail(configurationProperties.getNamaRuang(), configurationProperties.getLokRuang(), configurationProperties.getKuotaFail());
		String expect = configurationProperties.getKuotaFail();
		String hasil = configurationProperties.getKuotaFail();
		assertEquals(expect,hasil);
		extentTest.log(LogStatus.PASS, "User membuat room baru invalid");
	}
	
	// E.Form Room
	
	@When("User membuat room baru")
	public void user_membuat_room_baru() {
		userAccessFormRoom.newRoom(configurationProperties.getNamaRuang(), configurationProperties.getLokRuang(), configurationProperties.getKuota());
		extentTest.log(LogStatus.PASS, "User membuat room baru");
	}
	
	@Then ("User melihat daftar room")
	public void user_melihat_daftar_room() {
		userAccessFormRoom.formRoom();
		extentTest.log(LogStatus.PASS, "User melihat daftar room");
	}
	
	// F.Form Add Schedule
	
	@Given ("User membuat form schedule")
	public void user_membuat_form_schedule() {
		userAccessFormAddSchedule.formSchedule(configurationProperties.getQuota());
		extentTest.log(LogStatus.PASS, "User membuat form schedule");
	}
	
	@When ("User memilih data")
	public void User_memilih_data() {
		userAccessFormAddSchedule.ceklisData();
		extentTest.log(LogStatus.PASS, "User memilih data");
	}
	
	// G.Fix Schedule
	@Given ("User melihat fix schedule")
	public void user_melihat_fix_schedule() {
		userAccessFixSchedule.clickFix();
		tunggu(3);
		driver.navigate().refresh();
		assertEquals(configurationProperties.getTxtfix(),userAccessFixSchedule.getTxtFix());
		extentTest.log(LogStatus.FAIL, "User melihat fix schedule");
	}
	
	// H.Participants
	@Given ("User mengakses form")
	public void user_mengakses_form() {
		userAccessParticipants.formParticipants();
		extentTest.log(LogStatus.PASS, "User mengakses form");
	}
	
	@When ("User menginput form")
	public void user_menginput_form() {
		userAccessParticipants.inputParticipants(configurationProperties.getNamapar(),configurationProperties.getMobilephone(), configurationProperties.getProduct());
		tunggu(3);
		assertEquals(configurationProperties.getTxtparticipants(),userAccessParticipants.getTxtParti());
		extentTest.log(LogStatus.FAIL, "User menginput form");
	}
	// I.Barcode Registration
	@Given("User mengetes tombol")
	public void user_mengetes_tombol() {
		driver.navigate().back();
		userAccessBarcodeRegistration.tesTombol();
		extentTest.log(LogStatus.PASS, "User mengetes tombol");
	}
	@When("User menginput id registrasi")
	public void user_menginput_id_registrasi() {
		userAccessBarcodeRegistration.inputRegis(configurationProperties.getBarcode());
		extentTest.log(LogStatus.PASS, "User menginput id registrasi");
	}
	
	// J.Barcode Registration Invalid
	@Given("User mengakses barcode random")
	public void user_mengakses_barcode_random() {
		userAccessBarcodeRegistrationInvalid.registBarcodeInvalid(configurationProperties.getBarcodeFail());
		tunggu(3);
		extentTest.log(LogStatus.PASS, "User mengakses barcode random");
	}
	
	// K.Search Data
	@When("User mencari data peserta")
	public void user_mencari_data_peserta() {
		userAccessSearchData.searchPeserta();
		extentTest.log(LogStatus.PASS, "User mencari data peserta");
	}
	
	@Then("User melihat detail peserta")
	public void user_melihat_detail_peserta() {
		userAccessSearchData.detailPeserta();
		extentTest.log(LogStatus.PASS, "User melihat detail peserta");
	}
	
	//	L.Schedule
	@When("User melihat list schedule")
	public void user_melihat_list_schedule() {
		userAccessSchedule.lihatList();
		extentTest.log(LogStatus.PASS, "User melihat list schedule");
		
	}
	
	@Then("User melihat detail schedule")
	public void user_melihat_detail_schedule() {
		userAccessSchedule.lihatDetail();
		extentTest.log(LogStatus.PASS, "User melihat detail schedule");
	}
	
	// M.Training Result
	@When("User mengecek training")
	public void user_mengecek_training() {
		userAccessTrainingResult.checkTraining();
		extentTest.log(LogStatus.PASS, "User mengecek training");
	}
	
	@Then("User mengupdate hasil")
	public void user_mengupdate_hasil() {
		userAccessTrainingResult.updateHasil();
		extentTest.log(LogStatus.PASS, "User mengupdate hasil");
	}
	
	// N.All View
	@When("User mencari tanggal")
	public void user_mencari_tanggal() {
		userAccessAllView.checkTanggal();
		extentTest.log(LogStatus.PASS, "User mencari tanggal");
	}
	
	@Then("User melihat laporan")
	public void user_melihat_laporan()	{
		userAccessAllView.melihatLaporan();
		extentTest.log(LogStatus.PASS, "User melihat laporan");
	}
	
	// O.Session
	@When("User melihat session")
	public void user_melihat_session() {
		userAccessSession.checkSession();
		extentTest.log(LogStatus.PASS, "User melihat session");
	}
	@Then("User mengklik trash")
	public void user_mengklik_trash() {
		userAccessSession.trashSession();
		extentTest.log(LogStatus.PASS, "User mengklik trash");
	}
	
	public static void tunggu (int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
