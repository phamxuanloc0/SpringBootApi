package com.example.springbootapi.service;

import com.example.springbootapi.entity.User;
import com.example.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }
    @Override
    public  User saveUser(User user) {
        return userRepository.save(user);
    }

}
