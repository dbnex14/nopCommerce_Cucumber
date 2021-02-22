package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	  @Before
	    public void setup() throws IOException
	    {

	        //Logger steps
	        logger= Logger.getLogger("nopcommerce");
	        PropertyConfigurator.configure("Log4j.properties");
	        logger.setLevel(Level.DEBUG);
	        //Logger steps done

	        //Loading Config.properties file steps
	        config=new Properties();
	        FileInputStream configPropfile = new FileInputStream("config.properties");
	        config.load(configPropfile);
	        //Loading Config.properties file is done


	        String br=config.getProperty("browser");

	        if (br.equals("firefox")) {
	            System.setProperty("webdriver.gecko.driver",config.getProperty("firefoxpath"));
	            driver = new FirefoxDriver();
	        }

	        else if (br.equals("chrome")) {
	            System.setProperty("webdriver.chrome.driver",config.getProperty("chromepath"));
	            driver = new ChromeDriver();
	        }

//	        else if (br.equals("ie")) {
//	            System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
//	            driver = new InternetExplorerDriver();
//	        }

	    }
	
	@Given("User launches browser")
	public void user_launches_browser() {
		loginPage = new LoginPage(driver);
	}
	
	@Given("Benutzer started browser")
	public void benutzer_started_browser() {
		loginPage = new LoginPage(driver);
	}

	@When("User opens Url {string}")
	public void user_opens_Url(String url) {
		logger.info("**** Opening URL ****");
		driver.get(url);
		//driver.manage().window().maximize();
	}

	@When("User enters email as {string} and password {string}")
	public void user_enters_email_as_and_password(String email, String password) {
		logger.info("**** Setting user email and password ****");
		loginPage.setEmail(email);
		loginPage.setPassword(password);
	}
	
	@When("Benutzer gibt die email addresse {string} und passwort {string}")
	public void benutzer_gibt_die_email_addresse_und_passwort(String email, String password) {
		logger.info("**** Setting user email and password ****");
		loginPage.setEmail(email);
		loginPage.setPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() throws InterruptedException {
		logger.info("**** User clicks Login button ****");
		loginPage.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("**** Loging failed ****");
			Assert.assertTrue(false);
		} else {
			logger.info("**** Loging passed ****");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User clicks on log out link")
	public void user_clicks_on_log_out_link() throws InterruptedException {
		logger.info("**** User clicks on logout link ****");
		loginPage.clickLogout();
		Thread.sleep(3000);
	}

	@And("close browser")
	public void close_browser() {
		logger.info("**** Closing browser ****");
		driver.quit();
	}

	//
	// Add Customer methods
	//
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addCustomerPage = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCustomerPage.getPageTitle());
	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		addCustomerPage.clickOnCustomersMenu();
	}

	@When("User clicks on customer menu item")
	public void user_clicks_on_customer_menu_item() throws InterruptedException {
		addCustomerPage.clickOnCustomersMenuItem();
	}

	@When("User clicks on Add new button")
	public void user_clicks_on_Add_new_button() {
		addCustomerPage.clickONAddNew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomerPage.getPageTitle());
	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		logger.info("**** User adding new customer ****");
		String email = randomString() + "@gmail.com";
		addCustomerPage.setEmail(email);
		addCustomerPage.setPassword("test123");
		// a customer cannot be in both customer roles
		addCustomerPage.setCustomerRoles("Guest");
		addCustomerPage.setManagerOfVendor("Vendor 2");
		addCustomerPage.setGender("Male");
		addCustomerPage.setFirstName("Dino");
		addCustomerPage.setLastName("Buljubasic");
		addCustomerPage.setDob("7/05/1985");
		addCustomerPage.setCompany("QA Company");
		addCustomerPage.setAdminContent("This is for testing ....");
	}

	@When("User cliks on Save button")
	public void user_cliks_on_Save_button() {
		logger.info("**** Saving customer data ****");
		addCustomerPage.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}

	//
	// search for customer by email
	//
	@When("User enters customer email")
	public void user_enters_customer_email() {
		logger.info("**** User searching for customer by email ****");
		searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		searchCustomerPage.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should find email in the search table")
	public void user_should_find_email_in_the_search_table() {
		boolean found = searchCustomerPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, found);
	}

	//
	// search for customer by name
	//

	@When("User enters customer first name")
	public void user_enters_customer_first_name() {
		searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.setFirstName("Victoria");
	}

	@When("User enters customer last name")
	public void user_enters_customer_last_name() {
		searchCustomerPage.setLastName("Terces");
	}

	@Then("User should find name in the search table")
	public void user_should_find_name_in_the_search_table() {
		logger.info("**** User searching for customer by name ****");
		boolean found = searchCustomerPage.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, found);
	}
}
