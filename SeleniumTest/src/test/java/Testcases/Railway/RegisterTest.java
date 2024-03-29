package Testcases.Railway;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common.Constant.Constant;
import org.testng.asserts.SoftAssert;


public class RegisterTest {
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
    public void TC07(){
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL,Constant.PASSWORD,Constant.PASSWORD,Constant.PID);

        String actualMsg = registerPage.getRegisSusscesMsg().getText();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg,expectedMsg,"Register message is not displayed as expected");
    }
    @Test
    public void TC11(){

        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL,Constant.BLACK,Constant.BLACK,Constant.BLACK);

        String[] expectedMsg ={"There're errors in the form. Please correct the errors and try again.",
                                "Invalid password length.",
                                "Invalid ID length."};
        String[] value ={"Register","password","Pid"};
        String actualMsg = "";
        SoftAssert softly = new SoftAssert();
        for (int i = 0; i< expectedMsg.length; i=i+1){
            switch (i){
                case 0:
                    actualMsg = registerPage.getRegisErrorMsg().getText();
                    break;
                case 1:
                    actualMsg = registerPage.getPasswordErrorMsg().getText();
                    break;
                case 2:
                    actualMsg = registerPage.getPidErrorMsg().getText();
                    break;
            }
            softly.assertEquals(actualMsg,expectedMsg[i],value[i]+" message is not displayed as expected");
        }
        softly.assertAll();
    }
}
