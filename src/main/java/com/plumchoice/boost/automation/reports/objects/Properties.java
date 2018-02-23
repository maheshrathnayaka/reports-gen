package com.plumchoice.boost.automation.reports.objects;

import java.util.List;

public class Properties {

    private List<Property> properties;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "properties=" + properties +
                '}';
    }
}
