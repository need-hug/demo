package com.example.car_factory;

/** 车辆信息接口
 * @className: Car
 * @author: need_hug
 * @dateTime: 2019/8/5 22:43
 * @version: 1.0
 */
public interface Car {

	/**
	 * 品牌信息
	 * @return
	 */
	Object findBrands();

	/**
	 * 车系列表
	 * @return
	 */
	Object findSeries();

	/**
	 * 车型列表
	 * @return
	 */
	Object findModels();

	/**
	 * 车型详情
	 * @return
	 */
	Object findModelDetails();

}
