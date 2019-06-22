import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    ChromeDriver wd;

    @BeforeSuite
    public void setUp() {
        wd = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        wd.quit();
    }

    public boolean isResultPresent() {
        try {
            wd.findElement(By.className("r"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
