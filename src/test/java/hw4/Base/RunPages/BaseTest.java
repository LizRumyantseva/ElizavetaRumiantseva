package hw4.Base.RunPages;

import hw4.Base.DriverUtils.DriverManager;
import hw4.Base.DriverUtils.WaitActions;
import hw4.Base.Pages.HomePage;
import hw4.Base.Steps.ActionTestSteps;
import hw4.Base.Steps.AssertionTestSteps;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    private WebDriver driver; //static protected
    private WaitActions wait;

    public String username;
    public String password;

    public HomePage homePage;

    public AssertionTestSteps assertionStep;
    public ActionTestSteps actionStep;

    @BeforeClass
    public void classSetUp() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File("src/test/resources/hw4/userdata.properties")));
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = new DriverManager().setupDriver();
        wait = new WaitActions(driver);
        SoftAssert softAssert = new SoftAssert();
        actionStep = new ActionTestSteps(driver, wait);
        assertionStep = new AssertionTestSteps(driver, softAssert, wait);
        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
