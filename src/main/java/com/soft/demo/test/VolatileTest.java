package com.soft.demo.test;

/** volatile
 * @Auther: lps
 * DateTime: 2019/4/28 11:15
 * @Version: 1.0
 */
public class VolatileTest {

    volatile boolean isRunning = true;
//    boolean isRunning = true;

    public void m() {
        System.out.println("m() start.....");
        while (isRunning) {

        }
        System.out.println("m() end.......");
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(volatileTest::m, "t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileTest.isRunning = false;
    }

}
