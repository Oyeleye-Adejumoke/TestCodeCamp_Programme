package Pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
        public LoginPage(WebDriver driver){this.driver =driver;

        }
        private WebDriver driver;

        //using By as locator for elements
        private By username=By.xpath("//*[@id=\"txtUsername\"]");

        public void enterUsername(String uName)
        {
           //find the username element and enter the username
           driver.findElement(username).sendKeys(uName);

        }

        public void enterUserPassword(String pwd)
        {

            WebElement passwordfield= driver.findElement(By.id("txtPassword"));
            passwordfield.sendKeys(pwd);

        }

        public DashboardPage clickloginBtn()
        {
            driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

            return new DashboardPage (driver);


        }

}






