package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CategoryPage {
	//Declaration
	@FindBy(xpath = "//h1[contains(text(),'Category')])")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text() =' New']")
	private WebElement newButton;
	
	 private String deletepath = "//td[text()='%s']/ancestor::tr/descendant::button[text()='Delete']";
	
	@FindBy(name ="delete")
	private WebElement deleteButton;
	
	@FindBy(xpath ="//h4[text()=' Succes!']")
	private WebElement successMessage;
	
	//Initialization
	
	public CategoryPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void deleteCategory(WebDriverUtility web, String categoryName) {
		web.convertPathToWebElement(deletepath, categoryName).click();
		deleteButton.click();
		
	}
	public String getSuccessMessage() {
		return successMessage.getText();

	}
}
