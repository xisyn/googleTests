package uiTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final Page page = new Page();

    @BeforeMethod
    public void setUp() {
        page.init();
    }

    @AfterMethod
    public void tearDown() {
        page.stop();
    }

}
