import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class Fixture {
  static String token = "";
  static String id = "";

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

  public static String patient =
      """
        {
          "gender": "MALE",
          "firstname": "Florian",
          "lastname": "Cowper",
          "birthDate": "1994-08-28",
          "phoneNumbers": [
            {
              "number": "+49 152 759406",
              "type": "MOBILE"
            }
          ],
          "email": "patient_test@email.com",
          "street": "Konrad-Zuse-Str. 19",
          "zipCode": "99099",
          "city": "Erfurt"
        }

        """;
}
