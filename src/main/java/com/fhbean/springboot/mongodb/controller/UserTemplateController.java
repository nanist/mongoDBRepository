package com.fhbean.springboot.mongodb.controller;

import com.fhbean.springboot.mongodb.entity.NewUser;
import com.fhbean.springboot.mongodb.service.UserDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * https://www.cnblogs.com/larrydpk/p/12735620.html
 * MongoTemplate的方式
 * @author lgn
 * @version 1.0
 * @date 2021/9/17 17:33
 */
@RestController
@RequestMapping("/userTemplate")
public class UserTemplateController {
    @Autowired
    private final UserDAL userDAL;

    public UserTemplateController(UserDAL userDAL) {
        this.userDAL = userDAL;
    }


    @GetMapping("")
    public List<NewUser> getAllUsers() {
        return userDAL.findAll();
    }

    @GetMapping("/{userId}")
    public NewUser getByUserId(@PathVariable String userId) {
        return userDAL.findById(userId);
    }

    @PostMapping("/addNewUser")
    @ResponseBody
    public NewUser addNewUser(@RequestBody NewUser user) {
        return userDAL.save(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId) {
        NewUser user = new NewUser();
        user.setUserId(userId);
        userDAL.deleteById(userId);
        return "deleted: " + userId;
    }

    @PutMapping("")
    public NewUser update(@RequestBody NewUser user) {
        return userDAL.save(user);
    }
}
