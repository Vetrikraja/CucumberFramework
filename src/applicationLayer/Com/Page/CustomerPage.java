package applicationLayer.Com.Page;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
	WebDriver driver = new ChromeDriver();
	//write constructor to access web driver methods
	public CustomerPage(WebDriver driver)
	{
	this.driver = driver;	
	}
	
	//define repository
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement ObjCustomerSupplierlink;
    @FindBy(xpath = "(//span[@data-caption='Add'])[1]")
    WebElement ObjClickAddIcon;
    @FindBy(name = "x_Customer_Number")
    WebElement ObjCustomerNumber;
    @FindBy(name = "x_Customer_Name")
    WebElement ObjCustomerName;
    @FindBy(name = "x_Address")
    WebElement ObjAddress;
    @FindBy(name = "x_City")
    WebElement ObjCity;
    @FindBy(name = "x_Country")
    WebElement ObjCountry;
    @FindBy(name = "x_Contact_Person")
    WebElement ObjContactperson;
    @FindBy(name = "x_Phone_Number")
    WebElement ObjPhonenumber;
    @FindBy(name = "x__Email")
    WebElement ObjEmail;
    @FindBy(name = "x_Mobile_Number")
    WebElement ObjMobilenumber;
    @FindBy(name = "x_Notes")
    WebElement ObjNotes;
    @FindBy(id = "btnAction")
    WebElement ObjClickAdd;
    @FindBy(xpath = "//button[normalize-space()='OK!']")
    WebElement ObjClickconfirmbutton;
    @FindBy(xpath = "(//button[contains(.,'OK')])[6]")
    WebElement ObjClickalertok;
    @FindBy(xpath = "//span[@data-phrase='SearchBtn']")
    WebElement ObjClicksearchpanel;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement ObjSearchTextbox;
    @FindBy(xpath = "//button[@name='btnsubmit']")
    WebElement ObjClicksearchbuttton;
    @FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
    
    //methods for add customer
    public boolean addCustomer(String customername,String Address,String City,String Country,String contactperson,String phonenumber,String Email,String mobilenumber,String Notes) throws Throwable
       {
    	Actions act = new Actions(driver);
    	act.moveToElement(this.ObjCustomerSupplierlink).click().perform();
    	act.pause(5000);
    	act.moveToElement(this.ObjClickAddIcon).click().perform();
    	Thread.sleep(2000);
    	String Exp_Data = this.ObjCustomerNumber.getAttribute("value");
    	this.ObjCustomerName.sendKeys(customername);
    	this.ObjAddress.sendKeys(Address);
    	this.ObjCity.sendKeys(City);
    	this.ObjCountry.sendKeys(Country);
    	this.ObjContactperson.sendKeys(contactperson);
    	this.ObjPhonenumber.sendKeys(phonenumber);
    	this.ObjEmail.sendKeys(Email);
    	this.ObjMobilenumber.sendKeys(mobilenumber);
    	this.ObjNotes.sendKeys(Notes);
    	this.ObjClickAdd.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	this.ObjClickconfirmbutton.click();
    	Thread.sleep(2000);
    	this.ObjClickalertok.click();
    	//if search textbox already displayed don't click search panel
    	if (!this.ObjSearchTextbox.isDisplayed()) 
    	
    		//click search panel button
    		this.ObjClicksearchpanel.click();
    		this.ObjSearchTextbox.clear();
    		this.ObjSearchTextbox.sendKeys(Exp_Data);
    		this.ObjClicksearchbuttton.click();
    		Thread.sleep(2000);
    		String Act_Data = this.webtable.getText();
    		if (Exp_Data.equals(Act_Data)) 
    		{
			Reporter.log("Customer Add Success::"+Exp_Data+"   "+Act_Data,true);
			return true;
			}
    		else 
    		{
    			Reporter.log("Customer Add Fail::"+Exp_Data+"   "+Act_Data,true);
    			return false;
    			
    		}
    		
			
		}
		
		
		
    
       }
    
    


