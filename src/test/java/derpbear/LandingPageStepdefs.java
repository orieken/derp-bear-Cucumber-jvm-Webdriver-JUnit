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

import java.lang.reflect.Constructor;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
        derpBearUrl = "http://derp-bear.herokuapp.com/";
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null){
            driver.close();
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
        //landingPage.pickExample("Basic Form Example");
//        String str = "derpbear.BasicFormExamplePage";
//
//        Class myClass =  Class.forName(str);
//        Constructor constructor = myClass.getConstructor();
//        Object dynamicInstanceOfMyClass = constructor.newInstance(driver);
        Thread.sleep(20000);
        System.out.println(driver.findElement(By.id("your_information")).getText());
    }

    @Then("^I should see be on the basic example page$")
    public void I_should_see_be_on_the_basic_example_page() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        String pageTitle = landingPage.driver.getTitle();
        assertThat(pageTitle, is(equalTo("Welcome to Derp-Bear")));
    }


}
