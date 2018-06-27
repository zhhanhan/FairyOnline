package fairyonlie.pagetest.forward;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class TeaHomePageTest extends BaseTest{

	@Test
	public void Login() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/user/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("test001","123456");
	}
	
	@Test(dependsOnMethods="Login")
	public void ShoppingCart() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//button[contains(.,'���ﳵ')]");	
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="ShoppingCart")
	public void pubCourse() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'�ѷ����γ�')]");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="pubCourse")
	public void audCourse() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'����˿γ�')]");
		Thread.sleep(5000);	
	}
	
	@Test(dependsOnMethods="audCourse")
	public void UP() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'�ϴ�')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'�������')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'��ʼ�ϴ�')]");
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods="UP")
	public void manData() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'���Ϲ���')]");
		Thread.sleep(5000);	
	}
	@Test(dependsOnMethods="manData")
	public void Report() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'�ٱ�')]");
		Thread.sleep(5000);	
	}
}
