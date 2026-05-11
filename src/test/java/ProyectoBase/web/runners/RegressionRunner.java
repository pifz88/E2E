package ProyectoBase.web.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags ="@Loginp")
public class RegressionRunner extends WebBaseRunner {

}
