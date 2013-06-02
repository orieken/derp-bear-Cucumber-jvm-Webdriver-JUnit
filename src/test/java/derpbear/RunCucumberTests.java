package derpbear;

import cucumber.api.junit.*;
import org.junit.runner.RunWith;


/**
 * Created with IntelliJ IDEA.
 * User: bisbot
 * Date: 6/2/13
 * Time: 3:42 PM
 * These are some basic cucumber run options
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"progress","html:target/cucumber"}
)

public class RunCucumberTests {
}
