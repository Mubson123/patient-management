import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class PatientIntegrationTest extends Fixture {

    @Test
    void shouldReturnNewPatientWithValidToken() {
        String patient = Fixture.patient;

        Response response =
                given()
                        .contentType("application/json")
                        .body(patient)
                        .when()
                        .post("/api/patients")
                        .then()
                        .statusCode(201)
                        .body("id", notNullValue())
                        .body("firstname", equalTo("Florian"))
                        .extract()
                        .response();
        id = response.jsonPath().getString("id");
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
