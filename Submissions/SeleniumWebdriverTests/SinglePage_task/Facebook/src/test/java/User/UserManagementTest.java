    package User;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeClass;
 import org.testng.annotations.Test;

 import java.util.concurrent.TimeUnit;


    public class UserManagementTest {
    //Import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
        public void setUp() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //launch chromedriver.exe file
        driver=new ChromeDriver();
        //input the website URL
        driver.get("https://www.facebook.com/");
        //wait for page to load for 5 seconds
        Thread.sleep(5000);
        //maximize the browser
        driver.manage().window().maximize();
        //Get page Title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @Test
    public void LoginTest() throws InterruptedException {
    //click on username and input valid username"Oyeleye Adejumoke"
     driver.findElement(By.id("email")).sendKeys("Oyeleye Adejumoke");
     //click on password and input valid password"temiladeadejumoke"
      driver.findElement(By.id("pass")).sendKeys("temiladeadejumoke93");
      //click on login button
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
       if (driver.getCurrentUrl().contains("https://web.facebook.com/")){
           System.out.println("PASSED -User sucessfully logged in");

       }else {
           System.out.println("FAILED_User was unable to login");

       }
       Thread.sleep(5000);

    }
    @Test
        public void LogoutTest() throws InterruptedException {
        //click on user profile
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click();
        Thread.sleep(5000);
    }
     @AfterTest
        public void tearDown(){
        driver.quit();
    }

}
