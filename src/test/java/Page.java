import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {

    ChromeDriver wd;

    protected void init() {
        wd = new ChromeDriver();
    }

    protected void stop() {
        wd.quit();
    }

    protected boolean isResultPresent() {
        try {
            wd.findElement(By.className("r"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void goToGoogle() {
        wd.get("https://google.com");
    }

    protected String getTooltipText() {
        return wd.findElement(By.name("q")).getAttribute("title");
    }

    protected String getFirstResult() {
        return wd.findElement(By.xpath("(//*[@class=\"st\"]/*)[1]")).getText();
    }

    protected void clickLogo() {
        wd.findElement(By.id("logo")).click();
    }

    protected void search(String fullName) {
        WebElement searchField = wd.findElement(By.xpath("//div/input[@title=\"Поиск\"]"));
        searchField.sendKeys(fullName);
        searchField.submit();
    }
}
