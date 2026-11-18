package org.example.blogssystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.blogssystem.pojo.request.UserInfoRequest;
import org.example.blogssystem.pojo.response.UserInfoResponse;
import org.example.blogssystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/login")
    public UserInfoResponse userLogIn(@Validated @RequestBody UserInfoRequest userInfoRequest){
        return  userInfoService.login(userInfoRequest);

    }
}
