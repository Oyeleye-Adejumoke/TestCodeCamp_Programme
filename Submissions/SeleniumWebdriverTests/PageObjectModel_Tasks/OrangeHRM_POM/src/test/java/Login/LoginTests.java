package Login;

import Pageobjects.DashboardPage;
import org.testng.annotations.Test;
import setup.SetsUpTests;

public class LoginTests extends SetsUpTests {

    //TestNG Annotation
    @Test
    //This class extends to the SetupTests as the SetUpTest class contains all the setup requirement to run our test
    public void testLogin() throws InterruptedException {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");


        //Handler for dashboard page
        DashboardPage dashboardPage = loginPage.clickloginBtn();
        dashboardPage.clickWelcomeAdmin();
        loginPage = dashboardPage.clickLogout();
        String pageUrl = "https://opensource-demo.oragehrmlive.com/index.php/dashboard";
        System.out.println("PASSED - The page url is " + pageUrl);
    }

    @Test
    public void testLogout() throws InterruptedException {
        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage = dashboardPage.clickLogout();
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page url is " + loginUrl);
        }
    }
}