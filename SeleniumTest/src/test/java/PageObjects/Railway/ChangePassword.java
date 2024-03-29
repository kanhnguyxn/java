package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassword extends GeneralPage {
    private final By _txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By _txtConfPassword = By.xpath("//input[@id='confirmPassword']");
    private final By bntChangePassword = By.xpath("//input[@value='Change Password']");
    private final By SuccessMsg = By.xpath("//p[@class='message success']");
    private final By ErrorMsg = By.xpath("//p[@class='message error']");
    public WebElement getTxtCurrentPw(){
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    public WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    public WebElement getTxtConfPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfPassword);
    }
    public WebElement getBntChangepw(){
        return Constant.WEBDRIVER.findElement(bntChangePassword);
    }
    public WebElement getChangePWSuccessMess(){
        return Constant.WEBDRIVER.findElement(SuccessMsg);
    }
    public WebElement getChangePWErrorMess(){
        return Constant.WEBDRIVER.findElement(ErrorMsg);
    }
    public HomePage changePassword(String curentpasswd, String newpasswd, String confpasswd){
        this.getTxtCurrentPw().sendKeys(curentpasswd);
        this.getTxtNewPassword().sendKeys(newpasswd);
        this.getTxtConfPassword().sendKeys(confpasswd);
        this.getBntChangepw().click();

        return new HomePage();
    }
}
