package com.example.datetime;


import java.time.LocalDate;

/**
 * @className: DateTimeTest
 * @author: need_hug
 * @dateTime: 2019/7/3 13:46
 * @version: 1.0
 */
public class DateTimeTest {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		LocalDate localDate1 = LocalDate.parse("2019-11-23");
		System.out.println(localDate1);
	}

}
