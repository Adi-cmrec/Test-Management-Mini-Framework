package framework;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private String name;
    private List<TestCase> testCases;

    public TestSuite(String name) {
        this.name = name;
        this.testCases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "name='" + name + '\'' +
                ", testCases=" + testCases +
                '}';
    }
}