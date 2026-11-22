package org.example.blogssystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.blogssystem.pojo.request.UserInfoRequest;
import org.example.blogssystem.pojo.response.UserInfoResponse;
import org.example.blogssystem.pojo.response.UserLoginResponse;
import org.example.blogssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public UserLoginResponse userLogIn(@Validated @RequestBody UserInfoRequest userInfoRequest){
        return  userService.login(userInfoRequest);

    }

    @PostMapping("/getUserInfo")
    public UserInfoResponse userInfoResponse(Integer userId){
        return userService.getUserInfo(userId);
    }

    @PostMapping("/getAuthorInfo")
    public  UserInfoResponse userInfoResponseByBlog(Integer blogUserId){
        return userService.getUserInfoByBlog(blogUserId);
    }
}
