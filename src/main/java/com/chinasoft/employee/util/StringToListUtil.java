package com.chinasoft.employee.util;

import java.util.ArrayList;
import java.util.List;

public class StringToListUtil {
	/**
	 * string转List
	 * @param str
	 * @return
	 */
	public static List<Integer> conversion(String str) {
		List<Integer> listS = new ArrayList<>();
		if (null != str && str.length() > 0) {
			String[] split = str.split(",");
			if (null != split && split.length > 0) {
				for (int i = 0; i < split.length; i++) {
					listS.add(Integer.valueOf(split[i]));
				}
			}
		}
		return listS;
	}
}
