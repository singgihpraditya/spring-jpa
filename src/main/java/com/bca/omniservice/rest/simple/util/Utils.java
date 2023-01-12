package com.bca.omniservice.rest.simple.util;

public class Utils {
	public static String getHashCodeNumber() {
		int min = 100000;
		int max = 999999;
	    return "["+(int) ((Math.random() * (max - min)) + min)+"]";
	}
}
