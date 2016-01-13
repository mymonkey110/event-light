package com.haocai.web;

import com.haocai.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(String name, Integer age) {
        userService.register(name, age);
        return "register completed!";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login(String name) {
        userService.login(name);
        return "login completed!";
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String logout(String name) {
        userService.logout(name);
        return "logout completed!";
    }
}
