package com.soft.demo.jpa.repository;

import com.soft.demo.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: lps
 * DateTime: 2019/4/16 17:26
 * @Version: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Long countByUserName(String userName);

    User findUserByUserNameAndEnable(String userName, User.Enable enable);

    @Query(value = "select u from User u where userName = user.userName")
    User findUser(User user);


}
