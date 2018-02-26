package com.plumchoice.boost.automation.reports.objects;

public class Error {
    private String message;
    private String type;
    private String errorText;

    public Error() {
    }

    public Error(String message, String type, String errorText) {
        this.message = message;
        this.type = type;
        this.errorText = errorText;
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

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", errorText='" + errorText + '\'' +
                '}';
    }
}
