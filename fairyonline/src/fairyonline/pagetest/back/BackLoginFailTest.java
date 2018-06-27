package fairyonline.pagetest.back;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.BackLoginPage;
import fairyonline.webtest.core.BaseTest;

public class BackLoginFailTest extends BaseTest{
	
	String baseUrl ="http://localhost:8080/FairyOnline/admin/html/login.jsp";
	@Test(priority=0)
	public void loginFail() throws Exception{
		webtest.open(baseUrl);
		BackLoginPage LG=new BackLoginPage(webtest);
		LG.LoginFailed1();
		assertTrue(webtest.getHtmlSource().contains("ÕËºÅ»òÃÜÂë´íÎó£¬µÇÂ¼Ê§°Ü"));
	}
	@Test(priority=1)
	public void loginFai2() throws Exception{
		webtest.open(baseUrl);
		BackLoginPage LG=new BackLoginPage(webtest);
		LG.LoginFailed2();
		assertTrue(webtest.getHtmlSource().contains("ÕËºÅ»òÃÜÂë´íÎó£¬µÇÂ¼Ê§°Ü"));
	}
}
