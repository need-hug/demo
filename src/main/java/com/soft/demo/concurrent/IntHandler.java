package com.soft.demo.concurrent;

/** FunctionalInterface注解用于表用IntHandler是函数式接口
 * 函数式接口只能有一个抽象方法否则会报以下错误
 * Multiple non-overriding abstract methods found in interface com.soft.demo.concurrent.IntHandler
 * @Auther: lps
 * DateTime: 2019/4/19 16:41
 * @Version: 1.0
 */
@FunctionalInterface
public interface IntHandler {
    void handle(int i);

    //void handle1(int i);
}
