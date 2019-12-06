package com.cn.wanxi.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiRui
 */
public class DateUtils {

	/**
	 * 获取系统时间
	 */
	public String getNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
}
