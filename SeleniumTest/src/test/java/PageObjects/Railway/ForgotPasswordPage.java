package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    private final By tabForgotPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");

    protected WebElement getTabForgotPassword(){return  Constant.WEBDRIVER.findElement(tabForgotPassword);}

    public ForgotPasswordPage gotoForgotPasswordPage(){
        this.getTabForgotPassword();
        return new ForgotPasswordPage();
    }
}
