package com.example.creational;

/** 单例模式
 * 1.一个类只能有一个实例
 * 2.单例模式必须自己创建自己的实例
 * 3.单例模式必须给其他对象提供这一示例
 * @className: SingletonPattern
 * @author: need_hug
 * @dateTime: 2019/7/3 12:00
 * @version: 1.0
 */
public class SingletonPattern {

	private static SingletonPattern singletonPattern;

	private SingletonPattern() {
	}

	public static synchronized SingletonPattern getInstance() {
		if (null == singletonPattern) {
			singletonPattern = new SingletonPattern();
		}
		return singletonPattern;
	}

}

class SingletonPattern1 {
	// 创建singletonPattern1对象
	private static SingletonPattern1 singletonPattern1 = new SingletonPattern1();
	// 私有化构造方法
	private SingletonPattern1() {}
	// 获取唯一可用的对象
	public static SingletonPattern1 getInstance() {
		return singletonPattern1;
	}
}
