package com.soft.demo.jpa.service.impl;

import com.soft.demo.exception.BizException;
import com.soft.demo.jpa.entity.User;
import com.soft.demo.jpa.repository.UserRepository;
import com.soft.demo.jpa.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Auther: lps
 * DateTime: 2019/4/16 17:24
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 保存
     * @param user
     */
    @Override
    public void save(User user) {
        String userName = user.getUserName();
        if (userRepository.countByUserName(userName) > 0L){
            throw new BizException(4000, String.format("“%s”的用户已存在", userName));
        }
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}
