package fairyonlie.pagetest.forward;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;


public class TeacherApplication extends BaseTest{

	@Test
	public void Login() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/user/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("test001","123456");
	}

	
	
	@Test(dependsOnMethods="Login")
	public void teacApp() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,'头像')]");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='教师(申请)']");	
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='申请入住']");	
		Thread.sleep(3000);
		webtest.click("xpath=//input[@style='font-size:24px;']");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='下一步']");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'教师资格证')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'头像')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'分类')]");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='域名']","hah1012237");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='QQ']","1012237");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='邮箱']","hah1012237@163.com");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='简介']","风趣幽默，希望对大家有帮助");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='手机号']","15732163216");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'承诺书')]");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='提交资料']");
		Thread.sleep(3000);
		assertTrue(webtest.getHtmlSource().contains("提交成功"));
	}
	
}
