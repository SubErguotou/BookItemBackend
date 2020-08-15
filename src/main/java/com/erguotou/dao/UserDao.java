package com.erguotou.dao;

import com.erguotou.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username, String password);
}
