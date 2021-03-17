package setup;

import Pageobjects.DashboardPage;
import Pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetsUpTests {


        //create a WebDriver object
        private WebDriver driver;

        //create LoginPage Object
        protected LoginPage loginPage;


        //Create DashboardPage object
        protected DashboardPage dashboardPage;

        @BeforeTest
        public void Setup(){
            //selenium WebDriver needs this executable in order to know which browser to run your test
            //Browser Setup for Chrome
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            //Instantiate WebDriver Object
            driver=new ChromeDriver();
            //maximize the window browser
            driver.manage().window().maximize();
            //launch the application
            driver.get("https://opensource-demo.Orangehrmlive.com/");

            //Instantiate login page after launching the browser- Handle
            loginPage=new LoginPage(driver);
        }

        @AfterTest
        public void closeBrowser(){
            //".close" would close the window but the ".quit" would exit the session
            driver.quit();
        }





}
