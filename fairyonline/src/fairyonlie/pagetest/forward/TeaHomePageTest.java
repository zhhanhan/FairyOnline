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
		webtest.click("xpath=//button[contains(.,'购物车')]");	
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="ShoppingCart")
	public void pubCourse() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'已发布课程')]");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="pubCourse")
	public void audCourse() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'待审核课程')]");
		Thread.sleep(5000);	
	}
	
	@Test(dependsOnMethods="audCourse")
	public void UP() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'上传')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'继续添加')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'开始上传')]");
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods="UP")
	public void manData() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'资料管理')]");
		Thread.sleep(5000);	
	}
	@Test(dependsOnMethods="manData")
	public void Report() throws InterruptedException{
		webtest.click("xpath=//button[contains(.,'举报')]");
		Thread.sleep(5000);	
	}
}
