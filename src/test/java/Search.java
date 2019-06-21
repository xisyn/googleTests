import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search {
    ChromeDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
    }

    @Test
    public void searchTest() {
        wd.get("https://google.com");

        String fullName = "Хицунов Дмитрий Иванович";

        WebElement searchField = wd.findElement(By.xpath("//div/input[@title=\"Поиск\"]"));
        searchField.sendKeys(fullName);
        searchField.submit();

        WebElement firstResult = wd.findElement(By.xpath("(//*[@class=\"st\"]/*)[1]"));

        Assert.assertEquals(firstResult.getText(), fullName);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
