package com.fhbean.springboot.mongodb.service.impl;
import com.fhbean.springboot.mongodb.entity.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

import com.fhbean.springboot.mongodb.service.UserDAL;
import org.springframework.stereotype.Repository;

/**
 * @author lgn
 * @version 1.0
 * @date 2021/9/17 17:35
 */
@Repository
public class UserDALImpl implements UserDAL {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<NewUser> findAll() {
        return template.findAll(NewUser.class);
    }

    @Override
    public NewUser findById(String userId) {
        return template.findById(userId,NewUser.class);
    }

    @Override
    public NewUser save(NewUser user) {
        template.save(user);
        return user;
    }

    @Override
    public void deleteById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        template.remove(query, NewUser.class);
    }
}
