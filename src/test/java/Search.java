import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestBase {
    @Test
    public void testSearch() {
        String fullName = "Хицунов Дмитрий Иванович";

        wd.get("https://google.com");

        WebElement searchField = wd.findElement(By.xpath("//div/input[@title=\"Поиск\"]"));
        searchField.sendKeys(fullName);
        searchField.submit();

        WebElement firstResult = wd.findElement(By.xpath("(//*[@class=\"st\"]/*)[1]"));

        Assert.assertEquals(firstResult.getText(), fullName);

        WebElement searchBar = wd.findElement(By.name("q"));
        String tooltipText = searchBar.getAttribute("title");

        Assert.assertEquals(tooltipText, "Поиск");

        WebElement logo = wd.findElement(By.id("logo"));
        logo.click();

        Assert.assertFalse(isResultPresent());
    }
}
