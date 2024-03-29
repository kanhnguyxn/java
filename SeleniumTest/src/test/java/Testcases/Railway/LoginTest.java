package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.BLACK, Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Actual message after attempting to log in with blank username does not match expected message");
    }
    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Actual message after attempting to log in with an invalid password does not match the expected message");
    }
    @Test
    public void TC04(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
        HomePage homePage = new HomePage();
        homePage.open();

        if (homePage.isDisplayed(homePage.tabLogout)){
            homePage.gotoBookTicket();
        }
        else {
            LoginPage login = homePage.gotoLoginPage();
            if ( login.getBtnLogin().isDisplayed()){
                System.out.println("Login page is displayed when an unlogged user clicks on the \"Book ticket\" tab as expected.");
            }
        }
    }
    @Test
    public void TC05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i =0; i<5; i++){
            loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
        }

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Enter message is not displayed as expected");
    }
    @Test
    public void TC06(){
        System.out.println("TC06 - Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        boolean isDisplay = true;
        String content ="No display ";
        if (homePage.isDisplayed(loginPage.tabLogout) && homePage.isDisplayed(loginPage.tabMyTicket) && homePage.isDisplayed(loginPage.tabLogout)){
            MyTicketPage myticketPage = homePage.gotoMyTicketPage();
            if (myticketPage.getTxtTitle() == null){
                isDisplay = false;
                content = content +"my ticket page";
            }
            ChangePassword changePassword = homePage.gotoChangePasswordPage();
            if (changePassword.getTxtCurrentPw()==null){
                isDisplay = false;
                content = content+ " - change password page";
            }
        }
        if (isDisplay == false){
            System.out.println(content);
        }
    }

    @Test
    public void TC08(){
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.INVALID_USERNAME,Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"Enter message is not displayed as expected");
    }
    @Test
    public void TC13(){
        System.out.println("TC13 - Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();

    }

}
