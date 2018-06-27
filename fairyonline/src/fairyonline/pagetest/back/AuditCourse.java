package fairyonline.pagetest.back;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class AuditCourse extends BaseTest{

	@Test
	public void BackLogin() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/admin/html/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("admin","admin");
	}
	
	@Test(dependsOnMethods="BackLogin")
	public void passCourse() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 审核课程')]");
		webtest.click("xpath=.//*[@id='course']/div[1]/a]");	
		webtest.click("xpath=//input[@value='通过审核']");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="passCourse")
	public void failCourse() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 审核课程')]");
		webtest.click("xpath=.//*[@id='course']/div[2]/a]");	
		webtest.click("xpath=//input[@value='不予通过']");
		Thread.sleep(5000);
	}

}
