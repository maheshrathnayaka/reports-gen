package com.plumchoice.boost.automation.reports.parser;

import com.plumchoice.boost.automation.reports.objects.Error;
import com.plumchoice.boost.automation.reports.objects.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteHandler extends DefaultHandler {

    boolean bTestCase = false;
    boolean bFailure = false;
    boolean bError = false;
    boolean bSystemOut = false;
    private List<TestSuite> testSuiteList = new ArrayList<>();
    private TestSuite testSuite = new TestSuite();
    private Property property = new Property();
    private Failure failure = new Failure();
    private Error error = new Error();
    private List<Property> propertyList = new ArrayList<>();
    private List<TestCase> testCaseList = new ArrayList<>();
    private Properties properties = new Properties();
    private TestCase testCase = new TestCase();

    public List<TestSuite> getTestSuiteList() {
        return testSuiteList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("testsuite")) {
            String testSuiteName = attributes.getValue("name");
            double testSuiteTime = Double.parseDouble(attributes.getValue("time"));
            int testSuiteTests = Integer.parseInt(attributes.getValue("tests"));
            int testSuiteErrors = Integer.parseInt(attributes.getValue("errors"));
            int testSuiteSkipped = Integer.parseInt(attributes.getValue("skipped"));
            int testSuiteFailures = Integer.parseInt(attributes.getValue("failures"));
            testSuite.setName(testSuiteName);
            testSuite.setTime(testSuiteTime);
            testSuite.setTests(testSuiteTests);
            testSuite.setErrors(testSuiteErrors);
            testSuite.setSkipped(testSuiteSkipped);
            testSuite.setFailures(testSuiteFailures);
        } else if (qName.equalsIgnoreCase("property")) {
            String propertyName = attributes.getValue("name");
            String propertyValue = attributes.getValue("value");
            property.setName(propertyName);
            property.setValue(propertyValue);
            propertyList.add(property);
            testSuite.setProperties(new Properties(propertyList));
        }
        if (qName.equalsIgnoreCase("testcase")) {
            String testcaseName = attributes.getValue("name");
            String testcaseClassName = attributes.getValue("classname");
            double testcaseTime = Double.parseDouble(attributes.getValue("time"));
            testCase.setName(testcaseName);
            testCase.setClassname(testcaseClassName);
            testCase.setTime(testcaseTime);
            testCaseList.add(testCase);
            testSuite.setTestcase(testCaseList);
        } else if (qName.equalsIgnoreCase("failure")) {
            String failureMessage = attributes.getValue("message");
            String failureType = attributes.getValue("type");
            failure.setMessage(failureMessage);
            failure.setType(failureType);
            testCase.setFailure(failure);
            testCaseList.add(testCase);
            testSuite.setTestcase(testCaseList);
            bFailure = true;
        } else if (qName.equalsIgnoreCase("error")) {
            String errorMessage = attributes.getValue("message");
            String errorType = attributes.getValue("type");
            failure.setMessage(errorMessage);
            failure.setType(errorType);
            testCase.setError(error);
            testCaseList.add(testCase);
            testSuite.setTestcase(testCaseList);
            bError = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("properties")) {
            testSuiteList.add(testSuite);
        }
        else if (qName.equalsIgnoreCase("testcase")) {
            testCaseList.add(testCase);
            bTestCase = true;
        }
        if (qName.equalsIgnoreCase("system-out")) {
            bSystemOut = true;
            testSuiteList.add(testSuite);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bSystemOut) {
            testCase.setSystemOut(new String(ch, start, length));
            bSystemOut = false;
        } else if (bFailure) {
            failure.setFailureText(new String(ch, start, length));
            testCase.setFailure(failure);
            bFailure = false;
        } else if (bError) {
            error.setErrorText(new String(ch, start, length));
            testCase.setError(error);
            bError = false;
        }
    }
}
