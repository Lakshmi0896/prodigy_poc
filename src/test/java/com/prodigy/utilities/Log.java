package com.prodigy.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	// Initialize Log4j logs
	private static Logger Log = LogManager.getLogger(Log.class);

	// This is to print log for the beginning of the test case,
	public static void startTestCase(String sTestCaseName){
	Log.info(" -----------{Start of TestCase : "+sTestCaseName+"}----------------------");
	}

	//This is to print log for the ending of the test case
	public static void endTestCase(){
	Log.info("-----------{  End of TestCase }------------------------");
	}

	public static void info(String message) {
	Log.info(message);
	}

	public static void warn(String message) {
	Log.warn(message);
	}

	public static void error(Throwable throwable,String msg) {
	Log.error(throwable);
	Log.info(msg);
	}

	public static void fatal(String message) {
	Log.fatal(message);
	}

	public static void debug(String message) {
	Log.debug(message);
	}
}
