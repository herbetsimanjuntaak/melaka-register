package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/melaka-register-reports.html",
                "json:target/melaka-register-reports.json"
        },
        features = "src/test/resources/features",
        glue = "steps",
        monochrome = true

)
public class MelakaTestRunner extends BaseTestRunner
{

}
