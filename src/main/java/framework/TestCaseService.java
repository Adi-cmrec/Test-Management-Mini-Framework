package framework;

/**
 * Abstraction for TestCase CRUD operations.
 * Allows swapping between mock/in-memory and real HTTP implementation.
 */
public interface TestCaseService {
    ApiResponse<TestCase> create(TestCase testCase);
    ApiResponse<TestCase> get(int id);
    ApiResponse<TestCase> update(int id, TestCase updated);
}