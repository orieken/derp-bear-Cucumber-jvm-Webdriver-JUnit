package derpbear;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.matchers.JUnitMatchers;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/2/13
 * Time: 3:56 PM
 * Cucumber example with Webdriver and a page object framework
 */

public class LandingPageStepdefs {
    private WebDriver driver;
    private String derpBearUrl;

//hooks i want to move this later
    @Before
    public void setUp() {
        //derpBearUrl = "http://derp-bear.herokuapp.com/";
        derpBearUrl = "http://localhost:9393/";
        //driver = new ChromeDriver();

        try {
            driver = new IPhoneDriver("http://0.0.0.0:5555/wd/hub");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }

//steps
    @When("^I visit Derp-Bear$")
    public void I_visit_Derp_Bear() throws Throwable {
        driver.navigate().to(derpBearUrl);
    }

    @Then("^I should see a list of available examples$")
    public void I_should_see_a_list_of_available_examples() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        assertThat(landingPage.examplesList(), is(notNullValue()));
    }

    @When("^I pick a basic example$")
    public void I_pick_a_basic_example() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.selectExample("Basic Form Example");

        WebDriverWait waitingForPage = new WebDriverWait(driver, 15);
        waitingForPage.until(presenceOfElementLocated(By.id("your_information")));
    }

    @Then("^I should see be on the basic example page$")
    public void I_should_see_be_on_the_basic_example_page() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        String pageTitle = landingPage.driver.getTitle();
        assertThat(pageTitle, is(equalTo("Welcome to Derp-Bear")));
    }

    //Mobile
    @When("^I pick the Mobile Example$")
    public void I_pick_the_Mobile_Example() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.selectExample("Mobile Example");
    }

    @Then("^I should see the Project Name$")
    public void I_should_see_the_Project_Name() throws Throwable {
        MobileExamplePage mobileExamplePage = new MobileExamplePage(driver);
        assertThat(mobileExamplePage.getProjectName(), is(equalTo("Derp-Bear Mobile Examples")));
    }


}
