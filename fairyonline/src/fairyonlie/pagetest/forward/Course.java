package fairyonlie.pagetest.forward;

import org.testng.annotations.Test;

import fairyonline.pagetest.login.ForLoginPage;
import fairyonline.webtest.core.BaseTest;


public class Course extends BaseTest{

	@Test
	public void Login() throws Exception{
		webtest.open("http://localhost:8080/FairyOnline/user/login.jsp");
		ForLoginPage LG=new ForLoginPage(webtest);
		LG.LoginSuccess("test001","123456");
	}
	
	@Test(dependsOnMethods="Login")
	public void sportClick() throws InterruptedException{
		// TODO Auto-generated method stub
		webtest.click("xpath=//a[contains(.,'Ç°¶Ë¿ª·¢')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'Java')]");
		Thread.sleep(3000);
	}
	

}
