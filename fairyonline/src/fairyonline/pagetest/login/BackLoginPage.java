package fairyonline.pagetest.login;

import fairyonline.webtest.core.WebDriverEngine;

public class BackLoginPage {

	public WebDriverEngine webtest;
    public BackLoginPage(WebDriverEngine webtest) {
		this.webtest = webtest;	
    }


	public void LoginSucceed() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		webtest.type("xpath=//input[@name='name']", "admin");
		Thread.sleep(5000);
		webtest.type("xpath=//input[@name='password']", "admin");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
	}


	public void LoginFailed1() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		webtest.type("xpath=//input[@name='name']", "admin");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@name='password']", "111111");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		
	}
	public void LoginFailed2() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		webtest.type("xpath=//input[@name='name']", "adminn");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@name='password']", "admin");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		
	}

}