package fairyonline.pagetest.login;

import fairyonline.webtest.core.WebDriverEngine;

public class ForLoginPage {
	
    public WebDriverEngine webtest;
    public ForLoginPage(WebDriverEngine webtest) {
		this.webtest = webtest;
		
    }

 
	public void LoginSuccess(String name, String password) throws InterruptedException {
		// TODO Auto-generated method stub
        Thread.sleep(3000);
        webtest.type("xpath=//input[@id='txtName']",name);
		webtest.type("xpath=//input[@id='txtPass']",password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
	}
	
	public void LoginFailed1(String name, String password) throws InterruptedException {
		// TODO Auto-generated method stub
	
        Thread.sleep(3000);
        webtest.type("xpath=//input[@id='txtName']",name);
		webtest.type("xpath=//input[@id='txtPass']",password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
	}
	
	public void LoginFailed2(String name, String password) throws InterruptedException {
		// TODO Auto-generated method stub
	
        Thread.sleep(3000);
        webtest.type("xpath=//input[@id='txtName']",name);
		webtest.type("xpath=//input[@id='txtPass']",password);
		webtest.click("xpath=//input[@value='µÇÂ¼']"); 
	}
	
	
}
