package framework;

import java.util.ArrayList;
import java.util.List;

public class TestRun {
    private String runId;
    private List<TestSuite> testSuites;

    public TestRun(String runId) {
        this.runId = runId;
        this.testSuites = new ArrayList<>();
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public List<TestSuite> getTestSuites() {
        return testSuites;
    }

    public void addTestSuite(TestSuite testSuite) {
        this.testSuites.add(testSuite);
    }

    @Override
    public String toString() {
        return "TestRun{" +
                "runId='" + runId + '\'' +
                ", testSuites=" + testSuites +
                '}';
    }
}