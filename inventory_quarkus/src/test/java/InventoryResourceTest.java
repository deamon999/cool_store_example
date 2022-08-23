import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class InventoryResourceTest {

    @Test
    public void testInventoryEndpoint() {
        given()
                .when().get("/api/inventory/329299")
                .then()
                .statusCode(200)
                .body(is("{\"id\":329299,\"quantity\":35}"));
    }

    @Test
    public void testAllEndpoint() {
        given()
                .when().get("/api/inventory")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":100000,\"quantity\":0},{\"id\":165613,\"quantity\":45},{\"id\":165614,\"quantity\":87},{\"id\":165954,\"quantity\":43},{\"id\":329199,\"quantity\":12},{\"id\":329299,\"quantity\":35},{\"id\":444434,\"quantity\":32},{\"id\":444435,\"quantity\":53}]"));
    }

}
