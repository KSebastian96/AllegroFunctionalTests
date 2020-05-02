import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/changingPassword.feature",
        plugin = {"pretty", "html:report"})
public class ChangingPasswordTest_Run {
}
