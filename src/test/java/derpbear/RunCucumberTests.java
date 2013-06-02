package derpbear;

import cucumber.api.junit.*;
import org.junit.runner.RunWith;


/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/2/13
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"html:target/cucumber"}
)

public class RunCucumberTests {
}
