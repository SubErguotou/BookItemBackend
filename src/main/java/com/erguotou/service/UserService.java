package com.erguotou.service;


import com.erguotou.dao.UserDao;
import com.erguotou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    UserDao userdao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userdao.findByUsername(username);
    }

    public User get(String username, String password){
        return userdao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userdao.save(user);
    }
}