package com.soft.demo.jpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/** 用户实体类
 * @Auther: lps
 * DateTime: 2019/4/16 16:48
 * @Version: 1.0
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    @NotNull
    private String userName;

    /**
     * 用户密码
     */
    @NotNull
    private String password;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    @Column(name = "sex")
    private Sex sex;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
