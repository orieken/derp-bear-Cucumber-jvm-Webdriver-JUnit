package derpbear;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/2/13
 * Time: 4:04 PM
 * Add everything you want all pages to have access to here
 */
public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver() {
        return driver;
    }

}
