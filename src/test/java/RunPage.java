import Obgect.ObJectReal;
import Obgect.ObjPage;
import io.github.bonigarcia.wdm.WebDriverManager;
 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 import java.io.IOException;
import java.time.Duration;

public class RunPage extends ObJectReal {
    public RunPage(WebDriver driver) {
        super(driver);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        ObjPage.setDriver(driver);
        driver.get("https://cyclone.ua/uk/shop/1-din");
        ObJectReal page = new ObJectReal(driver);
        page.allTwelvElem();
        page.grabItems();
    }
}
