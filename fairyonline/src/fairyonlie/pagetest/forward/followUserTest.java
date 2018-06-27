package fairyonlie.pagetest.forward;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class followUserTest extends BaseTest{

	@Test
	public void Login() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/user/followUser.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("test001","123456");
	}
	
	@Test(dependsOnMethods="Login")
	public void followUser() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.type("xpath=//*[@id='found']/form/input","test002");	
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='found']/form/button");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'¹Ø×¢')]");
		Thread.sleep(5000);
		assertTrue(webtest.getHtmlSource().contains("ÒÑ¹Ø×¢"));
		Thread.sleep(5000);
	}
	
}
