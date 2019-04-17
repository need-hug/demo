package com.soft.demo.jpa.controller;

import com.soft.demo.jpa.entity.User;
import com.soft.demo.jpa.service.UserService;
import com.soft.demo.util.DateUtil;
import com.soft.demo.util.MsgObj;
import com.soft.demo.validation.BeanValidationUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Auther: lps
 * DateTime: 2019/4/16 16:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("add")
    public MsgObj add(User user) {
        BeanValidationUtil.beanValidation(user);
        user.setCreateDate(DateUtil.currentNow());
        userService.save(user);
        return new MsgObj();
    }

    @RequestMapping("edit")
    public MsgObj edit(User user) {
        Optional<User> optional = userService.findById(user.getId());
        User u = optional.get();
        u.setSex(user.getSex());
        u.setAge(user.getAge());
        userService.update(u);
        return new MsgObj(user);
    }

}
