package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// capture element locators
	By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
    By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstItemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By lstItemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	By lstItemGuests = By.xpath("//li[contains(text(), 'Guests')]");
	By lstItemVendors = By.xpath("//li[contains(text(), 'Vendors')]");
	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	// action methods for each element
	
	public void clickOnCustomersMenu() throws InterruptedException {
		driver.findElement(lnkCustomers_menu).click();
		Thread.sleep(3000);
	}
	
	public void clickOnCustomersMenuItem() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickONAddNew() {
		driver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		if (!role.equals("Vendors")) {
			driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		}
		
		driver.findElement(txtCustomerRoles).click();
		
		WebElement listItem;
		Thread.sleep(3000);
		
		if (role.equals("Administrators")) {
			listItem = driver.findElement(lstItemAdministrators);
		} else if(role.equals("Guests")) {
			listItem = driver.findElement(lstItemGuests);
		} else if(role.equals("Registered")) {
			listItem = driver.findElement(lstItemRegistered);
		} else if(role.equals("Vendors")) {
			listItem = driver.findElement(lstItemVendors);
		} else {
			listItem = driver.findElement(lstItemGuests);
		}
		
		//listItem.click();
		// whenever click action does not work, use JavascriptExecutor, so above and below are same
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", listItem);
	}
	
	public void setManagerOfVendor(String value) {
		Select drp=new Select(driver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		if (gender.equals("Male")) {
			driver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			driver.findElement(rdFemaleGender).click();
		} else {
			driver.findElement(rdMaleGender).click();
		}
	}
	
	public void setFirstName(String name) {
		driver.findElement(txtFirstName).sendKeys(name);
	}
	
	public void setLastName(String name) {
		driver.findElement(txtLastName).sendKeys(name);
	}
	
	public void setDob(String dob) {
		driver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompany(String company) {
		driver.findElement(txtCompanyName).sendKeys(company);
	}
	
	public void setAdminContent(String content) {
		driver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickOnSave() {
		driver.findElement(btnSave).click();
	}
}
