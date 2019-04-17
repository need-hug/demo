package com.soft.demo.constans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: lps
 * DateTime: 2019/4/9 16:31
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "dbname")
@Component
public class Constans {

    private static String test;

    public static String getTest() {
        return test;
    }

    public static void setTest(String test) {
        Constans.test = test;
    }
}
