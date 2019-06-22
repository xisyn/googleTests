import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected final Page page = new Page();

    @BeforeSuite
    public void setUp() {
        page.init();
    }

    @AfterSuite
    public void tearDown() {
        page.stop();
    }

}
