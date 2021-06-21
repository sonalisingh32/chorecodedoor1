package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {
	
	WebDriver driver=null;
	
	@Given("user is on search window")
	public void user_is_on_search_page() {
    System.getProperty("webdriver.chrome.driver","/eMovie_01_Cucumber/src/test/resources/selenium-drivers/chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.navigate().to("https://www.imdb.com/search");
	}
	
	@When("user types movie name")
	public void user_types_movie_name() {
	driver.findElement(By.name("q")).sendKeys("live free or die hard");
}
	
	@And("clicks on search button")
	public void clicks_on_search_button() {
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
  @Then("user is navigated to movie plot")
 public void user_is_navigated_to_movie_plot() {
	  driver.getPageSource().contains("Director");

}}