package derpbear;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/2/13
 * Time: 4:04 PM
 * Landing page for http://derp-bear.herokuapp.com/
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

    // taking a stab at one method to pick an example since they all
    //follow the same pattern "some_name_example"

    public Page pickExample(String exampleName) {
        String classExampleName = WordUtils.capitalize(exampleName).replaceAll(" ", "").concat("Page");

        selectExample(exampleName);
        return ttPage(classExampleName);
    }

    public Page selectExample(String exampleName){
        String modifiedExampleName = exampleName.replaceAll(" ", "_").toLowerCase();
        shortWait.until(presenceOfElementLocated(By.id(modifiedExampleName)));
        WebElement listItem = driver.findElement(By.id(modifiedExampleName));
        listItem.click();
        return this;
    }

}
