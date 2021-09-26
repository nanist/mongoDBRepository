package com.fhbean.springboot.mongodb.service;

import com.fhbean.springboot.mongodb.entity.NewUser;

import java.util.List;

/**
 * @author lgn
 * @version 1.0
 * @date 2021/9/17 17:34
 */
public interface UserDAL {
    List<NewUser> findAll();

    NewUser findById(String userId);

    NewUser save(NewUser user);

    void deleteById(String userId);
}
