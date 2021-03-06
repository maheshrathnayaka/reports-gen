package com.plumchoice.boost.automation.reports.objects;

public class Failure {

    private String message;
    private String type;
    private String failureText;

    public Failure() {
    }

    public Failure(String message, String type, String failureText) {
        this.message = message;
        this.type = type;
        this.failureText = failureText;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFailureText() {
        return failureText;
    }

    public void setFailureText(String failureText) {
        this.failureText = failureText;
    }

    @Override
    public String toString() {
        return "Failure{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
