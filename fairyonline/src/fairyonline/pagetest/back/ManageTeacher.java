package fairyonline.pagetest.back;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class ManageTeacher extends BaseTest{

	@Test
	public void BackLogin() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/admin/html/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("admin","admin");
	}
	
	@Test(dependsOnMethods="BackLogin")
	public void passTeacher() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理教师')]");
		webtest.click("xpath=.//*[@id='teacher']/div[1]/a]");	
		webtest.click("xpath=//input[@value='通过审核']");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="passTeacher")
	public void failTeacher() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理教师')]");
		webtest.click("xpath=.//*[@id='teacher']/div[2]/a]");	
		webtest.click("xpath=//input[@value='不予通过']");
		Thread.sleep(5000);
	}

}
