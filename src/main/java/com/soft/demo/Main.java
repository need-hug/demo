package com.soft.demo;

import java.math.BigDecimal;

/**
 * @className: Main
 * @author: need_hug
 * @dateTime: 2019/7/4 16:20
 * @version: 1.0
 */
public class Main {

	public static void main(String[] args) {
		equals_float();
		equals_Float();
		System.out.println("===========");
		equals_BigDecimal();
	}

	public static void equals_float() {
		float a = 1.0f - 0.9f;
		float b = 0.9f - 0.8f;

		System.out.println(Float.valueOf(a).toString());
		System.out.println(a);
		System.out.println(b);
		if (a == b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static void equals_Float() {
		Float a = Float.valueOf(1.0f - 0.9f); // 0.100000024
		Float b = Float.valueOf(0.9f - 0.8f); // 0.099999964

		System.out.println(a);
		System.out.println(b);
		if (a.equals(b)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static void equals_BigDecimal() {
		BigDecimal a = new BigDecimal(0.1);
		System.out.println(a);
		BigDecimal b = new BigDecimal("0.1");
		System.out.println(b);
	}

}
