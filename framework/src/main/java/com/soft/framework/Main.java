package com.soft.framework;

import com.soft.framework.entity.StatusCode;
import com.soft.framework.entity.UserDemo;
import com.soft.framework.exception.APIException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * className: Main
 * author: peishuai.li
 * dateTime: 2019/6/5 16:36
 * version: 1.0
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        UserDemo ud = new UserDemo();
        ud.setSex("M");
        ud.setAge(20);
        ud.setUserName("jack");

        try {
            if (ud.getPassword() == null) {
                throw new APIException(StatusCode.NO_PARAM);
            }
        } catch (APIException e){
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

}
