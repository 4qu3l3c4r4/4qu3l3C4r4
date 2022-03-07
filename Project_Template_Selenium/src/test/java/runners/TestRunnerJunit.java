package runners;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import excel.ExcelReadTest;
import testcases.GooglePlaceTest;


public class TestRunnerJunit {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(GooglePlaceTest.class, ExcelReadTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());

	    }
	    
	}
}