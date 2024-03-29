package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    public final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    public final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    public final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    public final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    public final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    public final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    public final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");


    //Elements: getter method for retrieving WebElements
    protected WebElement getTabLogin(){

        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getTabBookTicket(){

        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }
    protected WebElement getChangePassword(){
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getTabRegister(){return Constant.WEBDRIVER.findElement(tabRegister);}



    //Methods: page's methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicket() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
    public MyTicketPage gotoMyTicketPage(){
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }
    public ChangePassword gotoChangePasswordPage(){
        this.getChangePassword().click();
        return new ChangePassword();
    }
    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return  new RegisterPage();
    }
}
