package com.example.demobai5.service;

import com.example.demobai5.entity.User;
import com.example.demobai5.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save (User user){
        userRepository.save(user);
    }
}
