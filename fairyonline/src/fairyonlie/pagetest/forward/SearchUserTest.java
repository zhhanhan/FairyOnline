package fairyonlie.pagetest.forward;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class SearchUserTest extends BaseTest{

	@Test
	public void Login() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/user/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("test001","123456");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Login")
	public void Search1() throws InterruptedException{

		webtest.type("xpath=.//*[@id='found']/form/input","test002");	
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='found']/form/button");
		Thread.sleep(3000);
		
	}
	@Test(dependsOnMethods="Search1")
	public void Search2() throws InterruptedException{

		webtest.type("xpath=.//*[@id='found']/form/input","@@@");	
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='found']/form/button");
		Thread.sleep(3000);
		
	}
	@Test(dependsOnMethods="Search2")
	public void Search3() throws InterruptedException{

		webtest.type("xpath=.//*[@id='found']/form/input","test");	
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='found']/form/button");
		Thread.sleep(3000);
		
	}
}
