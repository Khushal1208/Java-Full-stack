package com.khushal.service;

import com.khushal.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    
    private Map<Integer, User> userDB ;
    
    public UserService() {
        userDB = new HashMap<>();
    }

    public User createUser(User userReq) {
        if(userDB.containsKey(userReq.getId())){
            return null;
        }

        userDB.put(userReq.getId(), userReq);
        return userReq;
    }

    public User getUserById(Integer id) {
        return userDB.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDB.values());
    }

    public Boolean deleteUser(Integer idParam) {
        if(!userDB.containsKey(idParam)){
            return false;
        }
        userDB.remove(idParam);
        return true;
    }

    public Boolean updateUser(User userReq) {
        if(!userDB.containsKey(userReq.getId())){
            return false;
        }
        userDB.put(userReq.getId(),userReq);
        return true;
    }
}
