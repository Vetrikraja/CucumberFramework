package applicationLayer.Com.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
@FindBy(xpath = "//a[starts-with(text(),'Logout')]")
WebElement ObjLogout;
public void adminLogout()
{
	ObjLogout.click();
}
}
