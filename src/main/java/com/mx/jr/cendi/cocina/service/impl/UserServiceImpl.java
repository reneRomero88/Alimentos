package com.mx.jr.cendi.cocina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jr.cendi.cocina.model.User;
import com.mx.jr.cendi.cocina.repository.UserRepository;
import com.mx.jr.cendi.cocina.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}