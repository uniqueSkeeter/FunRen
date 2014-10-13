package com.fr.station.common.utility;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorLogUtil {

	public static String printInfo(Exception e){
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		return sw.toString();
	}
}
