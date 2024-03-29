package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    private final By txtEmail= By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPid = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By txtRegisSusscesMsg = By.xpath("//div[@id='content']/p");
    private final By RegisErrorMsg = By.xpath("//p[@class='message error']");
    private final By passwordErrorMsg = By.xpath("//label[@for='password'][@class='validation-error']");
    private final By pidErrorMsg = By.xpath("//label[@for='pid'][@class='validation-error']");

    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    public WebElement getTxtPassword(){
        return  Constant.WEBDRIVER.findElement(txtPassword);
    }
    public WebElement getTxtConfPassword(){
        return  Constant.WEBDRIVER.findElement(txtConfPassword);
    }
    public  WebElement getTxtPid(){
        return  Constant.WEBDRIVER.findElement(txtPid);
    }
    public WebElement getBtnRegister(){
        return  Constant.WEBDRIVER.findElement(btnRegister);
    }
    public  WebElement getRegisSusscesMsg(){
        return  Constant.WEBDRIVER.findElement(txtRegisSusscesMsg);
    }
    public WebElement getRegisErrorMsg(){return Constant.WEBDRIVER.findElement(RegisErrorMsg);}
    public WebElement getPasswordErrorMsg(){return Constant.WEBDRIVER.findElement(passwordErrorMsg);}
    public WebElement getPidErrorMsg(){return Constant.WEBDRIVER.findElement(pidErrorMsg); }
    public HomePage register(String email, String password, String confPassword, String pid){
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfPassword().sendKeys(confPassword);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegister().click();

        return new HomePage();
    }
}
