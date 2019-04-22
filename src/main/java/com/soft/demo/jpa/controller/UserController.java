package com.soft.demo.jpa.controller;

import com.soft.demo.jpa.entity.User;
import com.soft.demo.jpa.service.UserService;
import com.soft.demo.util.BeanUtils;
import com.soft.demo.util.DateUtil;
import com.soft.demo.util.Logger;
import com.soft.demo.util.MsgObj;
import com.soft.demo.validation.BeanValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        Logger.info("source:"+user.toString());
        Logger.info("target:" + u.toString());
        BeanUtils.copyPropertiesIgnoreNull(user, u);

        Logger.info("result:"+u.toString());

        userService.update(u);
        return new MsgObj(u);
    }

    @RequestMapping("list")
    public MsgObj list(Integer pageNumber, Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Order.desc("createDate")));
        Page<User> users = userService.findAll(page);
        return new MsgObj(users);
    }
}
