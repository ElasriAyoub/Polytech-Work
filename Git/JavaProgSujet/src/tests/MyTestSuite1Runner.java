package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestSuite1Runner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(MyTestSuite1.class);
		for (Failure fail : result.getFailures()) 
		{
			System.out.println(fail.toString());
		}
		if (result.wasSuccessful()) 
		{
			System.out.println("All tests finished successfully...");
		}
	}
}