package fairyonline.pagetest.back;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.BackLoginPage;
import fairyonline.webtest.core.BaseTest;

public class BackLoginSuccessTest extends BaseTest{
	
	String baseUrl ="http://localhost:8080/FairyOnline/admin/html/login.jsp";
	
	@Test
	public void loginSuccess() throws Exception{
		webtest.open(baseUrl);
		BackLoginPage LG=new BackLoginPage(webtest);
		LG.LoginSucceed();
		assertTrue(webtest.getHtmlSource().contains("�˳���¼"));
	}
	@Test
	public void logOff() throws Exception{
		webtest.open(baseUrl);
		webtest.click("xpath=//input[@value='�˳���¼']");
		assertTrue(webtest.getHtmlSource().contains("��¼"));
	}

}
