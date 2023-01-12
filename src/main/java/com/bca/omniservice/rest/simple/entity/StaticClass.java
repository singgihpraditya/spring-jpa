package com.bca.omniservice.rest.simple.entity;

import java.util.HashMap;
import java.util.Map;

public class StaticClass {
	public static Map<String, Object> map;

	public static Map<String, Object> getMap() {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		return map;
	}
}
