package com.vishal.splitwise.service;

import com.vishal.splitwise.model.User;
import com.vishal.splitwise.repository.UserRepository;

public class UserService {

    public void createUser(User user){
        UserRepository.userMap.putIfAbsent(user.getId(), user);
    }
}
