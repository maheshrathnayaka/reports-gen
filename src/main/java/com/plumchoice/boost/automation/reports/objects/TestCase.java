package com.plumchoice.boost.automation.reports.objects;

public class TestCase {

    private String name;
    private String classname;
    private double time;
    private Failure failure;
    private Error error;
    private String systemOut;

    public TestCase() {
    }

    public TestCase(String name, String classname, double time, Failure failure, Error error, String systemOut) {
        this.name = name;
        this.classname = classname;
        this.time = time;
        this.failure = failure;
        this.error = error;
        this.systemOut = systemOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Failure getFailure() {
        return failure;
    }

    public void setFailure(Failure failure) {
        this.failure = failure;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getSystemOut() {
        return systemOut;
    }

    public void setSystemOut(String systemOut) {
        this.systemOut = systemOut;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", time='" + time + '\'' +
                ", failure=" + failure +
                ", systemOut='" + systemOut + '\'' +
                '}';
    }
}
