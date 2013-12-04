package com.java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithRegex {
	/**
	 * 
	 * @param s - incoming string
	 * @param regExp - regular expression string
	 * @return - true if incoming string 's' is match the refExp and false if is not.
	 */
	public static boolean checkLine(String s, String regExp){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(s);
		boolean b = matcher.matches();
		return b;
	}
}
