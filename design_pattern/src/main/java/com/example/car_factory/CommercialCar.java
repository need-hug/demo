package com.example.car_factory;

import lombok.extern.slf4j.Slf4j;

/** 商用车接口
 * @className: CommercialCar
 * @author: need_hug
 * @dateTime: 2019/8/5 22:51
 * @version: 1.0
 */
@Slf4j
public class CommercialCar implements Car {
	@Override
	public Object findBrands() {
		System.out.println("findBrands商用车品牌列表" + CarProperties.COMMERCIAL_BRAND);
		return null;
	}

	@Override
	public Object findSeries() {
		System.out.println("findSeries商用车系列列表" + CarProperties.COMMERCIAL_SERIES);
		return null;
	}

	@Override
	public Object findModels() {
		System.out.println("findModels商用车车型列表" + CarProperties.COMMERCIAL_MODELS);
		return null;
	}

	@Override
	public Object findModelDetails() {
		System.out.println("findModelDetails商用车车型详情" + CarProperties.COMMERCIAL_MODEL_DETAILS);
		return null;
	}
}
