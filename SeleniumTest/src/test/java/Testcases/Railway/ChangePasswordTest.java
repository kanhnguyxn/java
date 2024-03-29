package Testcases.Railway;

import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.ChangePassword;
public class ChangePasswordTest {
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
    public void TC09(){
        System.out.println("TC09 - User can change password");
        HomePage homePage =new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        ChangePassword changePassword = homePage.gotoChangePasswordPage();
        changePassword.changePassword(Constant.PASSWORD, Constant.PASSWORD_CHANGE, Constant.PASSWORD_CHANGE);

        String actualMsg = changePassword.getChangePWSuccessMess().getText();
        String expectedMsg = "Your password has been updated";

        Assert.assertEquals(actualMsg,expectedMsg,"Change password message is not displayed as expected");
    }
    @Test
    public void TC10(){
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");
        HomePage homePage =new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        ChangePassword changePassword = homePage.gotoChangePasswordPage();
        changePassword.changePassword(Constant.PASSWORD, Constant.PASSWORD_CHANGE, Constant.PASSWORD);

        String actualMsg = changePassword.getChangePWErrorMess().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"Change password message is not displayed as expected");
    }

}
