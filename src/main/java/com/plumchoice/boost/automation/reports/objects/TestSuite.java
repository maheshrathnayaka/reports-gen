package com.plumchoice.boost.automation.reports.objects;

import java.util.List;

public class TestSuite {

    private String name;
    private double time;
    private int tests;
    private int errors;
    private int skipped;
    private int failures;
    private Properties properties;
    private List<TestCase> testcase;

    public TestSuite() {
    }

    public TestSuite(String name, double time, int tests, int errors, int skipped, int failures, Properties properties, List<TestCase> testcase) {
        this.name = name;
        this.time = time;
        this.tests = tests;
        this.errors = errors;
        this.skipped = skipped;
        this.failures = failures;
        this.properties = properties;
        this.testcase = testcase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<TestCase> getTestcase() {
        return testcase;
    }

    public void setTestcase(List<TestCase> testcase) {
        this.testcase = testcase;
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", tests='" + tests + '\'' +
                ", errors='" + errors + '\'' +
                ", skipped='" + skipped + '\'' +
                ", failures='" + failures + '\'' +
                ", properties=" + properties +
                ", testcase=" + testcase +
                '}';
    }
}
