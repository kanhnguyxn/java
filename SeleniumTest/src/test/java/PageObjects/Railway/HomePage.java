package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class HomePage extends  GeneralPage{
    //Locators
    //Elements
    //Methods
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
        //This is a method that starts ours test cases
    }
    public boolean isDisplayed (By variable) {
        try {
            WebElement element = Constant.WEBDRIVER.findElement(variable);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isValidEmail(String email){
        if (email==null){
            return false;
        }
        if (email.length()<6 || email.length()>320){
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
