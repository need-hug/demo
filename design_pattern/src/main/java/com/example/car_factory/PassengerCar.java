package com.example.car_factory;

import lombok.extern.slf4j.Slf4j;

/** 乘用车接口
 * @className: PassengerCar
 * @author: need_hug
 * @dateTime: 2019/8/5 22:48
 * @version: 1.0
 */
@Slf4j
public class PassengerCar implements Car {
	@Override
	public Object findBrands() {
		System.out.println("乘用车品牌列表" + CarProperties.PASSENGER_BRAND);
		log.info("com.example.car_factory.PassengerCar.findBrands:乘用车品牌列表");
		return null;
	}

	@Override
	public Object findSeries() {
		System.out.println("乘用车车系列表" + CarProperties.PASSENGER_SERIES);
		log.info("com.example.car_factory.PassengerCar.findSeries：乘用车车系列表");
		return null;
	}

	@Override
	public Object findModels() {
		System.out.println("乘用车车型列表" + CarProperties.PASSENGER_MODELS);
		log.info("com.example.car_factory.PassengerCar.findModels:乘用车车型列表");
		return null;
	}

	@Override
	public Object findModelDetails() {
		System.out.println("乘用车详情" + CarProperties.PASSENGER_MODEL_DETAILS);
		log.info("com.example.car_factory.PassengerCar.findModelDetails:乘用车详情");
		return null;
	}
}
