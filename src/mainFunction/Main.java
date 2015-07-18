package mainFunction;

import junit.framework.Test;
import junit.framework.AssertionFailedError;
import junit.framework.TestSuite;
import junit.textui.ResultPrinter;
import junit.textui.TestRunner;
import validationTest.CheckConnectionTest;

public class Main {
    public static void main(String[] args) {
    	Main testRunner = new Main();
    	testRunner.runTest();
    }
    
    public void runTest(){
        TestRunner testRunner = new TestRunner();
        testRunner.setPrinter(new ResultPrinter(System.out) {
            boolean isfailed = false;

            public void startTest(Test test) {
                getWriter().print("running test case: " + test + "...");
                isfailed = false;
            }

            public void addFailure(Test test, AssertionFailedError t) {
                getWriter().println("Failed");
                isfailed = true;
            }

            public void endTest(Test test) {
                if (!isfailed) {
                    getWriter().println("Success");
                }
            }
        });

      testRunner.doRun(new TestSuite(CheckConnectionTest.class));
    }
}