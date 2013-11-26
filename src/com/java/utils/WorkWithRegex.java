package com.java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithRegex {
	public static boolean checkLine(String s, String regExp){
		Pattern pattern = Pattern.compile(regExp);//"(([\\d]*)[\\s][a-zA-Z-]*[\\s][a-zA-Z-]*[\\s][1-5]\\.[\\d][\\s][1-5][\\d]{2})");
		//String str = "11 Mikhaletskiy Yuri 4.7 521";
		Matcher matcher = pattern.matcher(s);
		boolean b = matcher.matches();
		return b;
	}
}
