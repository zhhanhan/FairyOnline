package fairyonline.pagetest.back;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class Title extends BaseTest{

	@Test
	public void BackLogin() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/admin/html/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("admin","admin");
	}
	
	@Test(dependsOnMethods="BackLogin")
	public void titleUser() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,' 管理用户权限')]");
		webtest.click("xpath=.//*[@id='user']/div[3]/a]");	
		webtest.type("xpath=//input[@type='time']","1");
		webtest.type("xpath=//textarea[@style='padding:5px 8px;']","留言含敏感词汇");
		webtest.click("xpath=//input[@value='确认封号']");
		Thread.sleep(5000);
	}

}
