package com.mx.jr.cendi.cocina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jr.cendi.cocina.model.User;
import com.mx.jr.cendi.cocina.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Boolean saveUser(@RequestBody User u) {
        return userService.saveUser(u);
    }
}