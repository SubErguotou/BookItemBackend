package com.erguotou.controller;

import com.erguotou.pojo.User;
import com.erguotou.result.Result;
import com.erguotou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/login")
    @CrossOrigin
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
