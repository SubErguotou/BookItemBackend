package com.erguotou.controller;

import com.erguotou.pojo.User;
import com.erguotou.result.Result;
import com.erguotou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/login")
    @CrossOrigin
    public Result login(@RequestBody User requestUser, HttpSession session){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
//            把用户信息存入session中
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
