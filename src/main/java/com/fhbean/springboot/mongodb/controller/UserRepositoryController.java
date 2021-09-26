package com.fhbean.springboot.mongodb.controller;
import com.fhbean.springboot.mongodb.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fhbean.springboot.mongodb.entity.NewUser;
import java.util.List;

/**
 * MongoRepository方式
 * @author lgn
 * @version 1.0
 * @date 2021/9/26 13:40
 */
@RestController
@RequestMapping("/userRepository")
public class UserRepositoryController {
    @Autowired
    private final UserRepository userRepository;

    public UserRepositoryController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getAllUsers")
    public List<NewUser> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public NewUser getByUserId(@PathVariable String userId) {
        return userRepository.findById(userId).orElse(new NewUser());
    }

    @PostMapping("")
    public NewUser addNewUser(@RequestBody NewUser user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId) {
        NewUser user = new NewUser();
        user.setUserId(userId);
        userRepository.deleteById(userId);
        return "deleted: " + userId;
    }

    @PutMapping("")
    public NewUser update(@RequestBody NewUser user) {
        return userRepository.save(user);
    }
}
