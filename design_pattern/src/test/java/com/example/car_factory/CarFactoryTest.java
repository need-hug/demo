package com.example.car_factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: CarFactoryTest
 * @author: need_hug
 * @dateTime: 2019/8/5 23:02
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarFactoryTest {

	@Test
	public void findBrands() {
		Car car0 = CarFactory.getInstance(0);
		car0.findBrands();
		car0.findSeries();
		car0.findModels();
		car0.findModelDetails();
		Car car1 = CarFactory.getInstance(1);
		car1.findBrands();
		car1.findSeries();
		car1.findModels();
		car1.findModelDetails();
	}
}
