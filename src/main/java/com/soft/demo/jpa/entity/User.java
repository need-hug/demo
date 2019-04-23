package com.soft.demo.jpa.entity;

import org.springframework.format.annotation.DateTimeFormat;

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

    public enum Enable {
        Y,N
    }
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
    @Enumerated(EnumType.STRING)  // Enum存入数据库默认为int 设置为以字符串方式存入
    @Column(name = "sex")
    private Sex sex;

    @Transient // 忽略该属性与数据库中字段的映射关系
    private String deptName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "enable")
    private Enable enable;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP) // 时间注解
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 设置时间格式
    private Date createDate;

    public User() {
    }

    public User(@NotNull String userName, @NotNull String password, Integer age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Enable getEnable() {
        return enable;
    }

    public void setEnable(Enable enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", deptName='" + deptName + '\'' +
                ", enable=" + enable +
                ", createDate=" + createDate +
                '}';
    }
}
