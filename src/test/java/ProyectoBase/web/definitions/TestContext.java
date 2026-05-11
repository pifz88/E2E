package ProyectoBase.web.definitions;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ProyectoBase.base.BrowserFactory;
import ProyectoBase.base.BrowserFactory.Browser;
import ProyectoBase.base.Constant;
import ProyectoBase.base.ScenarioContext;
import ProyectoBase.base.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestContext {
    private Scenario scenario;
    private ScenarioContext context;
    private String tcId;
    private static int lastEvidence = 0;
    private Browser browserSet;
    private Date startDate;
    private static String takeEvidence;
    private static String rallyExcecution;
    private static String buildRefference;
    static {
        takeEvidence = System.getProperty("evidence", "onlyErrors");
        rallyExcecution = System.getProperty("rallyExcecution", "Regression");
        buildRefference = System.getProperty("build", "Regression Test Excecution");
    }

    public TestContext(ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void prepareTest(Scenario scenario) throws Throwable {
        startDate = new Date();
        this.scenario = scenario;
        this.browserSet = Utils.readAndLoadByTags(scenario.getSourceTagNames());
        this.context.setContext("starDate", startDate);
        tcId = Utils.readTestCaseTags(scenario.getSourceTagNames());
        System.setProperty("downloadFolder",
                new File("output/" + new SimpleDateFormat("yyyyMMddHHmmss").format(startDate)).getAbsolutePath());
        this.context.setContext("global_data", Utils.getData(Constant.GLOBAL_DATA_PATH));
        this.context.setDriver(instanceDriver());
        System.setProperty("downloadFolder", "");
    }

    public WebDriver instanceDriver() throws Exception {
        WebDriver result;
        switch (browserSet) {
        case chrome:
            result = BrowserFactory.instanceChromeDriver();
            break;
        case firefox:
            result = BrowserFactory.instanceFirefoxDriver();
            break;
        case iexplorer:
            result = BrowserFactory.instanceIExplorerDriver();
            break;
        case safari:
            result = BrowserFactory.instanceSafariDriver();
            break;
        case edge:
            result = BrowserFactory.instanceEdgeDriver();
            break;
        default:
            throw new Exception("Driver no Implementado '" + browserSet + "'");
        }
        result.manage().window().setSize(BrowserFactory.setWebDimension());
        return result;
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (this.context.getDriver() != null) {
            this.context.getDriver().quit();
        }
    }

    @AfterStep
    public void afterStep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (this.scenario.isFailed()) {
            generateEvidence("[FAIL] Scenario ScreenShots");
        } else if (TestContext.takeEvidence.equalsIgnoreCase("fullEvidence")) {
            generateEvidence("[SUCCESS] Step ScreenShots");
        }
    }

    private void generateEvidence(String imageRefName) {
        byte[] screenShot = ((TakesScreenshot) this.context.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", imageRefName);
    }
}