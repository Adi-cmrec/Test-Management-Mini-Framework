package framework;

public class TestDriver {
    public static void main(String[] args) {
        // Initialize ConfigManager
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("Base URL: " + config.getBaseUrl());

        // Create test cases using the factory
        TestCase testCase1 = TestCaseFactory.createTestCase(1, "Login Test", "Verify login functionality");
        TestCase testCase2 = TestCaseFactory.createTestCase(2, "Signup Test", "Verify signup functionality");

        // Add test cases to a test suite
        TestSuite suite = new TestSuite("Authentication Tests");
        suite.addTestCase(testCase1);
        suite.addTestCase(testCase2);

        // Add test suite to a test run
        TestRun testRun = new TestRun("Run_001");
        testRun.addTestSuite(suite);

        // Display test run details
        System.out.println(testRun);
    }
}