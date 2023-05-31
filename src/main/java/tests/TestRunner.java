package tests;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

public class TestRunner {
    //EXT
    public static final String PROPERTIES = ".properties";
    public static final String XML = ".xml";

    public static void main(String args[]) throws Exception {
        String rootPath = new File("").getAbsolutePath();
        if (rootPath.isEmpty()) {
            throw new Exception("Root directory cannot be identified.");
        }

        //Check if any arguments are provided
        if (args.length == 0) {
            System.out.println("No arguments passed.");
            System.exit(1);
        }

        boolean isSuiteFound = false;
        ArrayList<String> runSuitesList = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].toLowerCase().startsWith("-d")) {
                args[i] = args[i].substring(2);
            }

            String extension = args[i].substring(args[i].indexOf('.'));
            if (extension.isEmpty()) continue;

            String filePath = new File(args[i]).getAbsolutePath();

            if (extension.equals(PROPERTIES)) {
                pushProfileToSystemProperties(filePath);
            } else if (extension.equals(XML)) {
                runSuitesList.add(filePath);
                System.out.println("Test suite " + filePath + " was added to execution list.");
                isSuiteFound = true;
            }
        }

        if (!isSuiteFound) {
            System.out.println("No test suites specified.");
            System.exit(1);
        }


        TestNG testng = new TestNG();
        testng.setVerbose(10);
        XmlSuite suites = new XmlSuite();
        suites.setSuiteFiles(runSuitesList);

        try {
            testng.setXmlSuites(Collections.singletonList(suites));
        } catch (Exception e) {
            throw new Exception("Something wrong has happened on attempt to set xml suites to TestNG instance." + e.getMessage());
        }

        testng.run();
        System.exit(testng.getStatus());
    }

    //Putting variables from profile config file to environment variables (=properties) of JVM
    private static void pushProfileToSystemProperties(String profile) throws Exception {
        Properties props = new Properties();

        InputStream propertiesFileStream = new FileInputStream(profile);
        props.load(propertiesFileStream);

        Enumeration myProps = props.keys();
        while (myProps.hasMoreElements()) {
            String key = myProps.nextElement().toString();
            System.setProperty(key, props.getProperty(key));
        }

        System.out.println("Profile data from " + profile + " was pushed to JVM.");
    }
}
