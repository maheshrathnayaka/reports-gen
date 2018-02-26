package com.plumchoice.boost.automation.reports.parser;

import com.plumchoice.boost.automation.reports.objects.TestSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxParserXml {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            TestSuiteHandler handler = new TestSuiteHandler();
            saxParser.parse(new File("D:\\test.xml"), handler);
            List<TestSuite> testSuiteList = handler.getTestSuiteList();
            for (TestSuite testSuite : testSuiteList)
                System.out.println(testSuite);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
