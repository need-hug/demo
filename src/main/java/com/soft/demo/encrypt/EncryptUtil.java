package com.soft.demo.encrypt;


import java.util.Base64;

/**
 * className: EncryptUtil
 * author: peishuai.li
 * dateTime: 2019/6/18 14:28
 * version: 1.0
 */
public class EncryptUtil {

	public static void main(String[] args) {
		String phone = "18203971486";
		byte[] base64AfterStr = Base64.getEncoder().encode(phone.getBytes());
		String s = new String(base64AfterStr);
		System.out.println(s);
		byte[] base = Base64.getDecoder().decode(s.getBytes());
		System.out.println(new String(base));
	}

}
