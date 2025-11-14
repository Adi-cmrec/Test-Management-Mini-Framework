package framework;

/**
 * Demonstrates CRUD operations using the InMemoryTestCaseService
 * simulating REST endpoints.
 */
public class CrudDemoDriver {
    public static void main(String[] args) {
        TestCaseService service = new InMemoryTestCaseService();

        // CREATE
        ApiResponse<TestCase> createResp = service.create(new TestCase(1, "Login Test", "Verify login works"));
        printAndAssert("CREATE", createResp, 201);

        // GET success
        ApiResponse<TestCase> getResp = service.get(1);
        printAndAssert("GET existing", getResp, 200);

        // GET missing
        ApiResponse<TestCase> getMissing = service.get(99);
        printAndAssert("GET missing", getMissing, 404);

        // UPDATE success
        ApiResponse<TestCase> updateResp = service.update(1, new TestCase(1, "Login Test Updated", "Updated description"));
        printAndAssert("UPDATE", updateResp, 200);

        // UPDATE missing
        ApiResponse<TestCase> updateMissing = service.update(50, new TestCase(50, "Ghost", "Nope"));
        printAndAssert("UPDATE missing", updateMissing, 404);

        // CREATE duplicate
        ApiResponse<TestCase> dupCreate = service.create(new TestCase(1, "Duplicate", "Should fail"));
        printAndAssert("CREATE duplicate", dupCreate, 409);

        // CREATE invalid (blank name)
        ApiResponse<TestCase> invalidCreate = service.create(new TestCase(2, "", "Blank name"));
        printAndAssert("CREATE invalid", invalidCreate, 400);
    }

    private static void printAndAssert(String label, ApiResponse<TestCase> resp, int expectedStatus) {
        boolean statusOk = resp.getStatusCode() == expectedStatus;
        System.out.println(String.format("%s => status=%d expected=%d ok=%s body=%s message=%s",
                label,
                resp.getStatusCode(),
                expectedStatus,
                statusOk,
                resp.getBody(),
                resp.getMessage()));
    }
}
