package com.example.car_factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 车信息属性
 * @className: CarProperties
 * @author: need_hug
 * @dateTime: 2019/8/5 23:28
 * @version: 1.0
 */
@Component
public class CarProperties {

	public static String COMMERCIAL_BRAND;
	@Value("${car.commercial.brand}")
	public void setCommercialBrand(String commercialBrand) {
		CarProperties.COMMERCIAL_BRAND = commercialBrand;
	}
	public static String COMMERCIAL_SERIES;
	@Value("${car.commercial.series}")
	public void setCommercialSeries(String commercialSeries) {
		CarProperties.COMMERCIAL_SERIES = commercialSeries;
	}

	public static String COMMERCIAL_MODELS;
	@Value("${car.commercial.models}")
	public void getCommercialModels(String commercialModels) {
		CarProperties.COMMERCIAL_MODELS = commercialModels;
	}

	public static String COMMERCIAL_MODEL_DETAILS;
	@Value("${car.commercial.modelDetails}")
	public void getCommercialModelDetails(String commercialModelDetails) {
		CarProperties.COMMERCIAL_MODEL_DETAILS = commercialModelDetails;
	}
	public static String PASSENGER_BRAND;
	@Value("${car.passenger.brand}")
	public void setPassengerBrand(String passengerBrand) {
		CarProperties.PASSENGER_BRAND = passengerBrand;
	}
	public static String PASSENGER_SERIES;
	@Value("${car.passenger.series}")
	public void getPassengerSeries(String passengerSeries) {
		CarProperties.PASSENGER_SERIES = passengerSeries;
	}
	public static String PASSENGER_MODELS;
	@Value("${car.passenger.models}")
	public void getPassengerModels(String passengerModels) {
		CarProperties.PASSENGER_MODELS = passengerModels;
	}
	public static String PASSENGER_MODEL_DETAILS;
	@Value("${car.passenger.modelDetails}")
	public void getPassengerModelDetails(String passengerModelDetails) {
		CarProperties.PASSENGER_MODEL_DETAILS = passengerModelDetails;
	}

}
