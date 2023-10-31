package com.brijframework.production.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommanUtil {

	private static final String DATE_TIME_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	private static final long LIMIT = 10000000000L;
	private static long last = 0;

	public static long getID() {
	  // 10 digits.
	  long id = System.currentTimeMillis() % LIMIT;
	  if ( id <= last ) {
	    id = (last + 1) % LIMIT;
	  }
	  return last = id;
	}

	public static String getIdenNo(String prefix) {
		return String.format(prefix+"#%010d",getID());
	}
	
	public static Date toDate(String toStringDate) {
		if(toStringDate==null) {
			return null;
		}
		SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_TIME_YYYY_MM_DD_HH_MM);
		try {
			return dateFormat.parse(toStringDate);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String toDate(Date toDate) {
		if(toDate==null) {
			return "";
		}
		SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_TIME_YYYY_MM_DD_HH_MM);
		return dateFormat.format(toDate);
	}
	
}
