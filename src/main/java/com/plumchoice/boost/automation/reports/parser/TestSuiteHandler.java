package com.plumchoice.boost.automation.reports.parser;

import com.plumchoice.boost.automation.reports.objects.Failure;
import com.plumchoice.boost.automation.reports.objects.Property;
import com.plumchoice.boost.automation.reports.objects.TestSuite;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class TestSuiteHandler extends DefaultHandler {
    private List<TestSuite> testSuites = null;
    private TestSuite testSuite = new TestSuite();

    public List<TestSuite> getTestSuites() {
        return testSuites;
    }

    boolean bProperties = false;
    boolean bProperty = false;
    boolean bTestcase = false;
    boolean bFailure = false;
    boolean bSystemOut = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("testsuite")) {
            String testSuiteName = attributes.getValue("name");
            double testSuiteTime = Double.parseDouble(attributes.getValue("time"));
            int testSuiteTests = Integer.parseInt(attributes.getValue("tests"));
            int testSuiteErrors = Integer.parseInt(attributes.getValue("errors"));
            int testSuiteSkipped = Integer.parseInt(attributes.getValue("skipped"));
            int testSuiteFailures = Integer.parseInt(attributes.getValue("failures"));
            if (qName.equalsIgnoreCase("properties")) {
                if (qName.equalsIgnoreCase("property")) {
                    Property property = new Property();
                    property.setName(attributes.getValue("name"));
                    property.setValue(attributes.getValue("value"));
                    testSuite.getProperties().getProperties().add(property);
                    bProperty = true;
                } else {
                    bProperties = true;
                }
            } else if (qName.equalsIgnoreCase("testcase")) {
                if (qName.equalsIgnoreCase("failure")) {
                    Failure failure = new Failure();
                    failure.setMessage(attributes.getValue("message"));
                    failure.setType(attributes.getValue("type"));
                    testSuite.getTestcase().get(0).setFailure(failure);
                    bFailure = true;
                } else if (qName.equalsIgnoreCase("system-out")) {
                    bSystemOut = true;
                } else {
                    bTestcase = true;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("properties")) {
            testSuites.add(testSuite);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bProperties){

        }
    }
}
