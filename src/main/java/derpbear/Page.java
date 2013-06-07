package derpbear;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

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

//    public <T extends Page> T navigateTo(Class<T> type) {
//        driver.get(baseUrl + pagesToRelativePaths.get(type));
//
//        return getPage(type);
//    }

    public <T extends Page> T expectedPage(Class<T> type) {
        return getPage(type);
    }

    public Page ttPage(String pageName) {
        Class classz = null;
        try {
            classz = Class.forName("derpbear." + pageName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return getPage(classz);
    }


    public <T extends Page> T getPage(Class<T> type) {
        T page = null;

        try {
            page = type.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return page;
    }

}
