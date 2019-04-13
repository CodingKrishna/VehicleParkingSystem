/**
 * 
 */
package com.bhaskar.project_type.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bhaskar.project_type.exception.EnrollmentException;


/**
 * @author Banu Prakash
 *
 */
public class DateEditor {
	private static SimpleDateFormat sdf = 
		new SimpleDateFormat("dd-MM-yyyy");
	
	public static Date convertStringToDate(String dateStr) 
		throws EnrollmentException {
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
	 		 throw new 
	 		EnrollmentException("Wrong Date Format", e);
		}
		 
	}
}
