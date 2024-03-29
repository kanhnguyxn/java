package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    private final By _txtTitle = By.xpath("//h1[text()='Manage ticket']");
    public WebElement getTxtTitle(){
        return Constant.WEBDRIVER.findElement(_txtTitle);
    }

}
