package uiTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Search extends TestBase {
    String fullName = "Хицунов Дмитрий Иванович";
    @Test
    public void testSearch() {
        page.goToGoogle();
        page.search(fullName);
        assertEquals(page.getFirstResult(), fullName);
        assertEquals(page.getTooltipText(), "Поиск");
        page.clickLogo();
        assertFalse(page.isResultPresent());
    }
}
