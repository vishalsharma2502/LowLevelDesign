package com.vishal.splitwise.repository;

import com.vishal.splitwise.model.User;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public static Map<String, User> userMap = new HashMap<>();
}
