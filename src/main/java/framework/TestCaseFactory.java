package framework;

public class TestCaseFactory {
    public static TestCase createTestCase(int id, String name, String description) {
        return new TestCase(id, name, description);
    }
    public static TestCase createTestCase(int id, int name){
        return new TestCase(id, String.valueOf(name), "No Description");
    }
}