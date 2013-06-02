package derpbear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/2/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LandingPage extends Page{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    //elements
    By exampleListLocator = By.id("examples");


    public LandingPage examplesList(){
        driver.findElement(exampleListLocator);
        return this;
    }

}
