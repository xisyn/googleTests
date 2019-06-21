import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Search {
    @Test
    public void searchTest() {
        ChromeDriver wd = new ChromeDriver();
        wd.get("https://google.com");
    }
}
