package fairyonline.pagetest.back;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class CourseClassification extends BaseTest{

	@Test
	public void BackLogin() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/admin/html/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("admin","admin");
	}
	
	@Test(dependsOnMethods="BackLogin")
	public void deleteClassification() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理课程分类')]");
		webtest.click("xpath=//input[@type='删除']");	
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="deleteClassification")
	public void Classification() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//input[@type='详情']");	
		assertTrue(webtest.getHtmlSource().contains("返回"));
		Thread.sleep(5000);
	}
	
}
