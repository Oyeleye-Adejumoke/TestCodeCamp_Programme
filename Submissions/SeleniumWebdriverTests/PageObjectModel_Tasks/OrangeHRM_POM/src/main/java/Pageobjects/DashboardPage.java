package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
        public DashboardPage(WebDriver driver) { this.driver=  driver;}


        private WebDriver driver;

        //locate elements
        private By welcomeAdmin= By.cssSelector("#branding a:nth-child(2)");
        private By logout=By.linkText("Logout");

        //functions to interact with the element
        public void clickWelcomeAdmin () throws InterruptedException {
            //wait for 10 seconds before executing the action
            Thread.sleep(1000);
            driver.findElement(welcomeAdmin).click();
        }

        public LoginPage clickLogout() throws InterruptedException
            {
                //wait for 3 seconds before executing the task
                Thread.sleep(3000);
                driver.findElement(logout).click();
                return new LoginPage(driver);
             }


        }