package com;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.model.user;

@Controller
@RequestMapping(value = "/demo")
public class Demo {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public user test(int id){
        System.out.println("dddddddddd=================");
        return userService.getUser(1);
    }
}
