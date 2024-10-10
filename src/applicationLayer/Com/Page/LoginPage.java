package applicationLayer.Com.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//define repository
	@FindBy(xpath = "//button[@name='btnreset']")
	WebElement ObjReset;
	@FindBy(name = "username")
	WebElement ObjUser;
	@FindBy(name = "password")
	WebElement ObjPass;
	@FindBy(id = "btnsubmit")
	WebElement ObjLogin;
	//methods for login 
	public void adminLogin(String user,String pass)
	{
		ObjReset.click();
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		ObjLogin.click();
	}

}
