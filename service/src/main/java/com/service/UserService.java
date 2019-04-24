package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.dao.userMapper;
import com.test.model.user;

@Service
public class UserService {
    @Autowired
    private userMapper mapper;

    public user getUser(int id){
        user user = new user();
        user.setId(2l);
        user.setName("ddddd");
                mapper.insert(user);
        return user;
    }
}
