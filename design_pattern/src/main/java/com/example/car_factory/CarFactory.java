package com.example.car_factory;

/**
 * @className: CarFactory
 * @author: need_hug
 * @dateTime: 2019/8/5 22:55
 * @version: 1.0
 */
public class CarFactory {

	private static Car car;

	public static Car getInstance(Integer type) {
		if (null == type) {
			type = 0;
		}

		switch (type) {
			case 0:
				car = new PassengerCar();
				break;
			case 1:
				car = new CommercialCar();
				break;
			default: car = new PassengerCar();
		}
		return car;
	}
}
