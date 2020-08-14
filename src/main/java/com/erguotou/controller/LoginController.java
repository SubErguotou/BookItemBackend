package com.erguotou.controller;

import com.erguotou.pojo.User;
import com.erguotou.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {

    @RequestMapping("/api/login")
    @CrossOrigin
    public Result login(@RequestBody User user){
        System.out.println(user);
        String username = user.getUserName();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", user.getUserPassword())){
            String messsage = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else{
            return new Result(200);
        }
    }
}
