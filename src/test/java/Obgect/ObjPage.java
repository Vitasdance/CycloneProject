package Obgect;

 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ObjPage {
    protected static WebDriver driver;
    public ObjPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void setDriver(WebDriver webdriver){
        driver = webdriver;
    }



    }

