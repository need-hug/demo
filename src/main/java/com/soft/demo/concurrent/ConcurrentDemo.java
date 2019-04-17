package com.soft.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author need_hug
 * @version 2019年2月27日 下午3:30:13
 */
public class ConcurrentDemo {
	
	public static int count = 0;
	
	// 闭锁  new CountDownLatch(int args) 参数为需要等待完成的线程数
	static CountDownLatch cdl = new CountDownLatch(1000);
	
	// 如果不加上synchronized，由于并发写入，结果会小于1000
	public synchronized static void inc() throws InterruptedException {
		Thread.sleep(1);
		count++;
		cdl.countDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						ConcurrentDemo.inc();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}).start();
			new Thread(() -> {
				try {
					ConcurrentDemo.inc();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		System.out.println("主线程继续执行count="+count);
		cdl.await(); // 主线程等待子线程执行结束
		System.out.println("主线程等待子线程结束后count="+count);
	}
	
}
