package derpbear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/15/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class MobileExamplePage extends Page {
    public MobileExamplePage(WebDriver driver){
        super(driver);
    }

    By projectNameLocator = By.id("project_name");

    public String getProjectName(){
        shortWait.until(presenceOfElementLocated(projectNameLocator));
        return driver.findElement(projectNameLocator).getText();
    }
}
