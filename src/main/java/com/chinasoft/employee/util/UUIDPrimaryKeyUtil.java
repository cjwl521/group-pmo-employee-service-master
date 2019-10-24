package com.chinasoft.employee.util;

import java.util.UUID;

/**
 * 用于生成数据库表主键的工具
 * @author Jackie
 *
 */
public class UUIDPrimaryKeyUtil {

	public static String generation() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
}
