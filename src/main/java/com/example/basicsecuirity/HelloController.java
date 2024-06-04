package com.example.basicsecuirity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World! ";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "Welcome User ";
    }

    @PostMapping("register")
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "User Created Successfully!";

    }

}
