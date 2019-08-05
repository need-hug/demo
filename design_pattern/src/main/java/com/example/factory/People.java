package com.example.factory;

/**
 * @className: People
 * @author: need_hug
 * @dateTime: 2019/7/3 12:47
 * @version: 1.0
 */
public interface People {

	void sleep();
}

class Men implements People {

	@Override
	public void sleep() {
		System.out.println("men sleep");
	}
}

class Women implements People {

	@Override
	public void sleep() {
		System.out.println("women sleep");
	}
}

class PeopleFactory {

	private static People people;

	public static People getInstance(String classType) {
		if (classType.equals("MEN")) {
			people = new Men();
		} else if (classType.equals("WOMEN")) {
			people = new Women();
		}
		return people;
	}

}