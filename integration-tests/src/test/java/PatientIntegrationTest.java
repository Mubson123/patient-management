import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

class PatientIntegrationTest {
  static String token = "";

  @BeforeAll
  static void setUp() {
    RestAssured.baseURI = "http://localhost:4004";

    String loginPayload =
        """
                      {
                          "email": "testuser@test.com",
                          "password": "password123"
                      }
                      """;

    token =
        given()
            .contentType("application/json")
            .body(loginPayload)
            .when()
            .post("/auth/login")
            .then()
            .statusCode(200)
            .extract()
            .jsonPath()
            .get("token");
  }

  @Test
  void shouldReturnPatientsWithValidToken() {

    given()
        .header("Authorization", "Bearer " + token)
        .when()
        .get("/api/patients")
        .then()
        .statusCode(200)
        .body("patients", notNullValue());
  }
}
