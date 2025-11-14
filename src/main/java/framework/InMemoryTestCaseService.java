package framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock implementation simulating REST CRUD operations for TestCase.
 * This lets us validate logic without real HTTP calls.
 */
public class InMemoryTestCaseService implements TestCaseService {
    private final Map<Integer, TestCase> store = new HashMap<>();

    @Override
    public ApiResponse<TestCase> create(TestCase testCase) {
        if (testCase == null) {
            return new ApiResponse<>(400, null, "TestCase cannot be null");
        }
        if (store.containsKey(testCase.getId())) {
            return new ApiResponse<>(409, null, "TestCase with id already exists");
        }
        if (isBlank(testCase.getName()) || isBlank(testCase.getDescription())) {
            return new ApiResponse<>(400, null, "Name/Description required");
        }
        store.put(testCase.getId(), testCase);
        return new ApiResponse<>(201, testCase, "Created");
    }

    @Override
    public ApiResponse<TestCase> get(int id) {
        TestCase tc = store.get(id);
        if (tc == null) {
            return new ApiResponse<>(404, null, "Not Found");
        }
        return new ApiResponse<>(200, tc, "OK");
    }

    @Override
    public ApiResponse<TestCase> update(int id, TestCase updated) {
        if (!store.containsKey(id)) {
            return new ApiResponse<>(404, null, "Cannot update missing TestCase");
        }
        if (updated == null) {
            return new ApiResponse<>(400, null, "Updated TestCase cannot be null");
        }
        if (isBlank(updated.getName()) || isBlank(updated.getDescription())) {
            return new ApiResponse<>(400, null, "Name/Description required");
        }
        // Keep same id; ignore updated.getId() if different
        TestCase existing = store.get(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        return new ApiResponse<>(200, existing, "Updated");
    }

    private boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }
}
