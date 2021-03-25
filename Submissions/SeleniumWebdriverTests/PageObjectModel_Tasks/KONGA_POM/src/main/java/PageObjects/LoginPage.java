package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
        private WebDriver driver;
        private By nameofUser=By.id("username");
        private By passwordofUser=By.id("password");
        private By loginButton = By.xpath("//button[@class='_0a08a_3czMG _988cf_1aDdJ']");


        public LoginPage(WebDriver driver)
        {
            this.driver=driver;

        }

        //Input valid username
        public void enterusername (String hostName)
        {
            driver.findElement(nameofUser).sendKeys(hostName);

        }

        //Input Valid Password
        public void enterPassword (String hostPassword)
        {
            driver.findElement(passwordofUser).sendKeys(hostPassword);

        }

        //click on LoginButton
        public Homepage clickLoginButton() throws InterruptedException {
          driver.findElement(loginButton).click();
          Thread.sleep(5000);
          return new Homepage(driver);
        }


}




