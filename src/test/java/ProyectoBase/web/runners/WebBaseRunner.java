package ProyectoBase.web.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "ProyectoBase.web.definitions" }, features = "src/test/resources/features/web", plugin = {
        "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class WebBaseRunner {

}
