import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestBase {
    @Test
    public void testSearch() {
        String fullName = "Хицунов Дмитрий Иванович";
        page.goToGoogle();
        page.search(fullName);
        Assert.assertEquals(page.getFirstResult(), fullName);
        Assert.assertEquals(page.getTooltipText(), "Поиск");
        page.clickLogo();
        Assert.assertFalse(page.isResultPresent());
    }
}
