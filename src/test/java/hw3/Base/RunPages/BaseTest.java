package hw3.Base.RunPages;

import hw3.Base.DriverUtils.DriverManager;
import hw3.Base.DriverUtils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public  WaitActions wait;

    public String username;
    public String password;


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

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
