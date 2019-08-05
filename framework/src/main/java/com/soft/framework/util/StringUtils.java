package com.soft.framework.util;

/** java.lang.String操作工具类
 * className: StringUtils
 * author: peishuai.li
 * dateTime: 2019/6/5 16:19
 * version: 1.0
 */
public class StringUtils {

    /**
     * message不存在是返回默认字符串
     * @param message 字符串
     * @param defaultIfBlank 默认字符串
     * @return
     */
    public static String defaultIfBlank(String message, String defaultIfBlank) {
        return message == null ? defaultIfBlank : message;
    }
}
