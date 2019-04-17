package com.soft.demo.validation.entity;

import com.soft.demo.validation.groups.SaveGroups;
import com.soft.demo.validation.groups.UpdateGroups;

import javax.validation.constraints.NotNull;

/**
 * @Auther: lps
 * DateTime: 2019/2/27 17:36
 * @Version: 1.0
 */
public class User implements java.io.Serializable {

    private Integer id;

    @NotNull( message = "用户名不能为空")
    private String userName;

    @NotNull(message = "密码不能为空")
    private String password;

    private Integer age;

    private String edu;

    public User( String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }
}
