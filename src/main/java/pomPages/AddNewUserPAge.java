package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUserPAge {
	//Declaration
	@FindBy(xpath = "//b[text()='Add New User]")
	private WebElement pageHeader;
	
	@FindBy(xpath ="//input[@id='email]")
	private WebElement emailTF;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstnameTF;
	
	@FindBy(xpath= "//input[@id = 'lastname']")
	private WebElement lastnameTF;
	
	@FindBy(xpath = "//textarea[@id = 'address']")
	private WebElement addresstextareaTF;
	
	@FindBy(xpath ="//input[@id = 'contact']")
	private WebElement contactInfoTF;
	
	@FindBy(xpath ="//input[@id='Photo']")
	private WebElement photoUploadButton;
	
	@FindBy(xpath = "//button[text()=' Save' and @name='add']")
	private WebElement saveButton;
	
	//initialization
	public AddNewUserPAge(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	//utilization
	public String getpageHeader() {
		return pageHeader.getText();
		
	}
	public void setEmail(String  email) {
		emailTF.sendKeys(email);
	}
	public void setPassword(String password) {
		passwordTF.sendKeys(password);
		
	}
	public void setFirstname(String firstname) {
		firstnameTF.sendKeys(firstname);
		
	}
	public void setLastname(String lastname) {
		lastnameTF.sendKeys(lastname);
	}
	public void setAddress(String address) {
		addresstextareaTF.sendKeys(address);
	}
	public void setContactInfo(String contact) {
		contactInfoTF.sendKeys(contact);
	}
	public void uploadphoto(String photopath) {
		photoUploadButton.sendKeys(photopath);
	}
	public void clicksave() {
		saveButton.click();
	}
	

}
