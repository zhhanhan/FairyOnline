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
		webtest.click("xpath=//a[contains(.,'ͷ��')]");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='��ʦ(����)']");	
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='������ס']");	
		Thread.sleep(3000);
		webtest.click("xpath=//input[@style='font-size:24px;']");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='��һ��']");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'��ʦ�ʸ�֤')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'ͷ��')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'����')]");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='����']","hah1012237");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='QQ']","1012237");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='����']","hah1012237@163.com");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='���']","��Ȥ��Ĭ��ϣ���Դ���а���");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@value='�ֻ���']","15732163216");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'��ŵ��')]");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@value='�ύ����']");
		Thread.sleep(3000);
		assertTrue(webtest.getHtmlSource().contains("�ύ�ɹ�"));
	}
	
}
