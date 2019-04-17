package com.soft.demo.jpa.service;

import com.soft.demo.jpa.entity.User;

import java.util.Optional;

/**
 * @Auther: lps
 * DateTime: 2019/4/16 16:42
 * @Version: 1.0
 */
public interface UserService {

    void save(User user);

    Optional<User> findById(Integer id);

    void update(User user);
}
