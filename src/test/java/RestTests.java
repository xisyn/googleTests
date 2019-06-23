import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class RestTests {

    @Test
    public void testMethod() throws IOException, URISyntaxException {
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
            .header("Transfer-Encoding", equalTo("chunked"))
        .and()
            .body("items.title[0]", equalTo("ООО \"Танк-к\", Москва (ИНН 7703228474, ОГРН 1037739437966)"));
    }

    @Test
    public void testSchema() {
        given()
            .params("key", "AIzaSyA4juEzAjVFoyK64ZVG0D_S-96sR_HsLtg",
                "q", "7703228474",
                        "cx", "009273001490562717861:hi7m1d4fgss")
        .when()
            .get("https://www.googleapis.com/customsearch/v1")
        .then()
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
    }

}
