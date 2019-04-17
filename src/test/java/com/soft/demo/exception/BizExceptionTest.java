package com.soft.demo.exception;

import com.soft.demo.util.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: lps
 * DateTime: 2019/4/16 11:34
 * @Version: 1.0
 */
public class BizExceptionTest {

    @Test
    public void test() {
        Exception e = new BizException(400, "失败");
        Logger.info(e.getMessage());
    }

}