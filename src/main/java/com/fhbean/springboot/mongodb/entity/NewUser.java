package com.fhbean.springboot.mongodb.entity;
import org.springframework.data.annotation.Id;
import java.util.Date;
/**
 * @author lgn
 * @version 1.0
 * @date 2021/9/17 17:45
 */
public class NewUser {
    @Id
    private String userId;
    private String name;
    private Integer age;
    private Date createTime = new Date();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
