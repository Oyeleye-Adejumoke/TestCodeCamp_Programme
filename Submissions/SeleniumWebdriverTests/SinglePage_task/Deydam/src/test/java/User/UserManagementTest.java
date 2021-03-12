package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTest {
        //import selenium WebDriver
        private WebDriver driver;

    @BeforeClass
        public void setUp() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver=new ChromeDriver();
        //input the website URl
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        //wait for page to load for 5 seconds
        Thread.sleep(5000);
        //maximize the browser
        driver.manage().window().maximize();
        //Get the page Title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
        public void LoginTest() throws InterruptedException {
        //click on username and input valid username "oyeleyeadejumoke@gmail.com"
        driver.findElement(By.id("username")).sendKeys("oyeleyeadejumoke@gmail.com");
        //click on password field and input valid password "adejumoke"
        driver.findElement(By.id("password")).sendKeys("adejumoke");
        //click on login in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println("PASSED-User has successfully logged in");
        }else {
            System.out.println("FAILED - User was unable to login");
        }
        Thread.sleep(5000);
    }
    @Test
    public void LogoutTest() throws InterruptedException {
        //click on user profile
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

