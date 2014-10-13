package com.fr.station.common.utility;

import java.util.List;
import java.util.Map;

public class CodeHelper {
	
	public static boolean isNull(Object param) {
		return null == param;
	}
	
	public static boolean isNotNull(Object param) {
		return null != param;
	}
	
	public static boolean isNotNullOrEmpty(List<? extends Object> list) {
		return CodeHelper.isNotNull(list) && !list.isEmpty();
	}
	
	public static boolean isNotNullOrEmpty(Map<? extends Object, ? extends Object> map) {
		return CodeHelper.isNotNull(map) && !map.isEmpty();
	}
	
	public static boolean isNotNullOrEmpty(String str) {
		return CodeHelper.isNotNull(str) && !str.isEmpty();
	}
	
	public static boolean isNotNullOrEmpty(String str, int length) {
		return CodeHelper.isNotNull(str) && str.length() > length;
	}
	
	public static boolean isNotNullOrEmpty(Integer params) {
		return CodeHelper.isNotNull(params) && params.intValue() > 0;
	}
	
	public static boolean isNotNullOrEmpty(Object[] params) {
		return CodeHelper.isNotNull(params) && params.length > 0;
	}

	public static boolean isNullOrEmpty(Integer params) {
		return null == params || params.intValue() == 0;
	}
}
