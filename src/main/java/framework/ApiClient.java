package framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    public ApiClient() {
        RestAssured.baseURI = ConfigManager.getInstance().getBaseUrl();
    }

    public Response createTestCase(String name, String description) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + name + "\"," +
                        "\"description\": \"" + description + "\"}" +
                        "}")
                .post("/testcases");
    }

    public Response getTestCase(int id) {
        return RestAssured.given()
                .get("/testcases/" + id);
    }

    public Response updateTestCase(int id, String name, String description) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + name + "\"," +
                        "\"description\": \"" + description + "\"}" +
                        "}")
                .put("/testcases/" + id);
    }
}