package com.java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithRegex {
	public static boolean checkLine(String s, String regExp){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(s);
		boolean b = matcher.matches();
		return b;
	}
}
