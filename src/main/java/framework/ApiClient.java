package framework;

// import io.restassured.RestAssured;
// import io.restassured.response.Response;

public class ApiClient {


private final String baseUrl;

    public ApiClient() {
        this.baseUrl = ConfigManager.getInstance().getBaseUrl();
    }

    /**
     * Mock placeholder create method. Real implementation would perform HTTP POST.
     */
    public ApiResponse<TestCase> createTestCase(String name, String description) {
        TestCase tc = new TestCase(0, name, description); // id would come from server normally
        return new ApiResponse<>(501, tc, "Not Implemented - add REST Assured to enable real call");
    }

    /**
     * Mock placeholder get method.
     */
    public ApiResponse<TestCase> getTestCase(int id) {
        return new ApiResponse<>(501, null, "Not Implemented - GET " + baseUrl + "/testcases/" + id);
    }

    /**
     * Mock placeholder update method.
     */
    public ApiResponse<TestCase> updateTestCase(int id, String name, String description) {
        return new ApiResponse<>(501, null, "Not Implemented - PUT " + baseUrl + "/testcases/" + id);
    }


    // public ApiClient() {
    //     RestAssured.baseURI = ConfigManager.getInstance().getBaseUrl();
    // }

    // public Response createTestCase(String name, String description) {
    //     return RestAssured.given()
    //             .header("Content-Type", "application/json")
    //             .body("{" +
    //                     "\"name\": \"" + name + "\"," +
    //                     "\"description\": \"" + description + "\"}" +
    //                     "}")
    //             .post("/testcases");
    // }

    // public Response getTestCase(int id) {
    //     return RestAssured.given()
    //             .get("/testcases/" + id);
    // }

    // public Response updateTestCase(int id, String name, String description) {
    //     return RestAssured.given()
    //             .header("Content-Type", "application/json")
    //             .body("{" +
    //                     "\"name\": \"" + name + "\"," +
    //                     "\"description\": \"" + description + "\"}" +
    //                     "}")
    //             .put("/testcases/" + id);
    // }
}