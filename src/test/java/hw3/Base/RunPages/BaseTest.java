package hw3.Base.RunPages;

import hw3.Base.DriverUtils.DriverManager;
import hw3.Base.DriverUtils.WaitActions;
import hw3.Base.Pages.HomePage;
import hw3.ex1.Pages.FramePage;
import hw3.ex1.TestStepsEx1.AssertionTestStepsEx1;
import hw3.ex2.TestStepsEx2.AssertionTestStepsEx2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public WaitActions wait;

    public String username;
    public String password;

    public HomePage homePage;
    public FramePage framePage;

    public AssertionTestStepsEx1 testSteps1;
    public AssertionTestStepsEx2 testSteps2;


    @BeforeClass
    public void classSetUp() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File("src/test/resources/hw3/userdata.properties")));
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp() {
        driver = new DriverManager().setupDriver();
        wait = new WaitActions(driver);
        SoftAssert softAssert = new SoftAssert();
        homePage = new HomePage(driver, wait);
        framePage = new FramePage(driver, wait);
        testSteps1 = new AssertionTestStepsEx1(driver, softAssert, wait);
        testSteps2 = new AssertionTestStepsEx2(driver, softAssert, wait);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
