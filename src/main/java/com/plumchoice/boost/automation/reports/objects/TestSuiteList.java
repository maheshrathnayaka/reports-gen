package com.plumchoice.boost.automation.reports.objects;

public class TestSuiteList {

    private TestSuite testSuite;

    public TestSuite getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }

    @Override
    public String toString() {
        return "TestSuiteList{" +
                "testSuite=" + testSuite +
                '}';
    }
}
