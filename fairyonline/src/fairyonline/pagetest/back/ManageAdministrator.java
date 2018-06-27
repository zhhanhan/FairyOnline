package fairyonline.pagetest.back;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class ManageAdministrator extends BaseTest{

	@Test
	public void BackLogin() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/admin/html/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("admin","admin");
	}
	
	@Test(dependsOnMethods="BackLogin")
	public void Delete() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理管理员')]");
		webtest.click("xpath=.//*[@id='admin']/div[1]/a]");	
		webtest.click("xpath=//input[@value='删除此账号']");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Delete")
	public void Change() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理管理员')]");
		webtest.click("xpath=.//*[@id='admin']/div[2]/a]");	
		webtest.click("xpath=//input[@value='修改账号权限']");
		assertTrue(webtest.getHtmlSource().contains("返回"));
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Change")
	public void Check() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理管理员')]");
		webtest.click("xpath=.//*[@id='admin']/div[3]/a]");	
		webtest.click("xpath=//input[@value='查看账号密码']");
		assertTrue(webtest.getHtmlSource().contains("返回"));
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Check")
	public void newUser() throws InterruptedException{
		webtest.click("xpath=//a[contains(.,' 管理管理员')]");
		webtest.click("xpath=//a[contains(.,'注册新账号')]");
		Thread.sleep(3000);
		webtest.type("xpath=//input[@name='name']", "admin1");
		Thread.sleep(5000);
		webtest.type("xpath=//input[@name='password']", "admin");
		Thread.sleep(3000);
		webtest.click("xpath=.//*[@id='num']/div[1]/a]");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@value='确认创建']");
		Thread.sleep(3000);
		assertTrue(webtest.getHtmlSource().contains("返回"));
		Thread.sleep(5000);
	}
}
