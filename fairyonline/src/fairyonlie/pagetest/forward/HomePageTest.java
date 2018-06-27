package fairyonlie.pagetest.forward;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;

public class HomePageTest extends BaseTest{

	@Test
	public void Login() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/user/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("test001","123456");
	}
	
	@Test(dependsOnMethods="Login")
	public void Collection() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//*[@id='body1']/button[1]");	
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Collection")
	public void Learn() throws InterruptedException{
		webtest.click("xpath=//*[@id='body1']/button[2]");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Learn")
	public void Shopping() throws InterruptedException{
		webtest.click("xpath=//*[@id='body1']/button[3]");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="Shopping")
	public void TeaApplication() throws InterruptedException{
		webtest.click("xpath=//*[@id='body1']/button[4]");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="TeaApplication")
	public void TeaHomePage() throws InterruptedException{
		webtest.click("xpath=//*[@id='body1']/button[5]");
		Thread.sleep(5000);
	}
	
	@Test(dependsOnMethods="TeaHomePage")
	public void FollowUser() throws InterruptedException{
		webtest.click("xpath=//*[@id='body1']/button[6]");
		Thread.sleep(5000);
	}
	
	
}
