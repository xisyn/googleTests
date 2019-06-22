import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class RestTests {

    @Test
    public void test() throws IOException, URISyntaxException {

        given()
            .params("key", "AIzaSyA4juEzAjVFoyK64ZVG0D_S-96sR_HsLtg",
                "q", "7703228474",
                "cx", "009273001490562717861:hi7m1d4fgss")
        .when()
            .get("https://www.googleapis.com/customsearch/v1")
        .then()
            .assertThat()
            .statusCode(200)
        .and()
            .contentType(ContentType.JSON)
        .and()
            .header("Transfer-Encoding", equalTo("chunked"));
    }

}
