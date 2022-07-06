package com.juaracoding.magang.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

		@Value("${browser}")
		private String browser;
		
		@Value("${messageerrorlogin}")
		private String messageErrorLogin;
		
		@Value("${txtWelcome}")
		private String txtWelcome;
		
		@Value("${uname}")
		private String uname;
		
		@Value("${password}")
		private String password;
		
		@Value("${module}")
		private String module;
		
		@Value("${namaruang}")
		private String namaRuang;
		
		@Value("${lokruang}")
		private String lokRuang;
		
		@Value("${kuotafail}")
		private String kuotaFail;
		
		@Value("${kuota}")
		private String kuota;
		
		@Value("${barcodefail}")
		private String barcodeFail;
		
		@Value("${barcode}")
		private String barcode;

		@Value("${traintime}")
		private String traintime;
		
		@Value("${traindate}")
		private String traindate;
		
		@Value("${quota}")
		private String quota;
		
		@Value("${namapar}")
		private String namapar;
		
		@Value("${mobilephone}")
		private String mobilephone;
		
		@Value("${product}")
		private String product;
		
		@Value("${txtfix}")
		private String txtfix;
		
		@Value("${txtpartcipants}")
		private String txtparticipants;
		
		
		public String getTxtparticipants() {
			return txtparticipants;
		}

		public void setTxtparticipants(String txtparticipants) {
			this.txtparticipants = txtparticipants;
		}

		public String getTxtfix() {
			return txtfix;
		}

		public void setTxtfix(String txtfix) {
			this.txtfix = txtfix;
		}

		public String getTraindate() {
			return traindate;
		}

		public void setTraindate(String traindate) {
			this.traindate = traindate;
		}

		public String getMessageErrorLogin() {
			return messageErrorLogin;
		}

		public void setMessageErrorLogin(String messageErrorLogin) {
			this.messageErrorLogin = messageErrorLogin;
		}

		public String getTxtWelcome() {
			return txtWelcome;
		}

		public void setTxtWelcome(String txtWelcome) {
			this.txtWelcome = txtWelcome;
		}

		public String getNamapar() {
			return namapar;
		}

		public void setNamapar(String namapar) {
			this.namapar = namapar;
		}

		public String getMobilephone() {
			return mobilephone;
		}

		public void setMobilephone(String mobilephone) {
			this.mobilephone = mobilephone;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public String getTraintime() {
			return traintime;
		}

		public void setTraintime(String traintime) {
			this.traintime = traintime;
		}

		public String getQuota() {
			return quota;
		}

		public void setQuota(String quota) {
			this.quota = quota;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}

		public String getBarcodeFail() {
			return barcodeFail;
		}

		public void setBarcodeFail(String barcodeFail) {
			this.barcodeFail = barcodeFail;
		}

		public String getNamaRuang() {
			return namaRuang;
		}

		public void setNamaRuang(String namaRuang) {
			this.namaRuang = namaRuang;
		}

		public String getLokRuang() {
			return lokRuang;
		}

		public void setLokRuang(String lokRuang) {
			this.lokRuang = lokRuang;
		}

		public String getKuotaFail() {
			return kuotaFail;
		}

		public void setKuotaFail(String kuotaFail) {
			this.kuotaFail = kuotaFail;
		}

		public String getKuota() {
			return kuota;
		}

		public void setKuota(String kuota) {
			this.kuota = kuota;
		}

		public String getModule() {
			return module;
		}

		public void setModule(String module) {
			this.module = module;
		}

		public String getBrowser() {
			return browser;
		}

		public void setBrowser(String browser) {
			this.browser = browser; 
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
}
