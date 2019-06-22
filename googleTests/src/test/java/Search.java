import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Search extends TestBase {
    @Test
    public void testSearch() {
        String fullName = "Хицунов Дмитрий Иванович";
        page.goToGoogle();
        page.search(fullName);
        assertEquals(page.getFirstResult(), fullName);
        assertEquals(page.getTooltipText(), "Поиск");
        page.clickLogo();
        assertFalse(page.isResultPresent());
    }
}
