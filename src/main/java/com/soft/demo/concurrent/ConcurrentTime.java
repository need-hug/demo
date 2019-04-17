package com.soft.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author need_hug
 * @version 2019年2月27日 下午3:46:04
 */
public class ConcurrentTime {

	static CountDownLatch cdl = new CountDownLatch(3);
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
					System.out.println("线程1执行完成");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					cdl.countDown();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
					System.out.println("线程2执行完成");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					cdl.countDown();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
					System.out.println("线程3执行完成");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					cdl.countDown();
				}
			}
		}).start();
		
		cdl.await();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
}
