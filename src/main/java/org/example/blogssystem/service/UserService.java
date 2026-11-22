package org.example.blogssystem.service;

import org.example.blogssystem.pojo.dataObject.UserInfo;
import org.example.blogssystem.pojo.request.UserInfoRequest;
import org.example.blogssystem.pojo.response.UserInfoResponse;
import org.example.blogssystem.pojo.response.UserLoginResponse;

public interface UserService {

    UserInfo judgeUserInfo(UserInfoRequest userInfoRequest);

    UserLoginResponse login(UserInfoRequest userInfoRequest);

    UserInfoResponse getUserInfo(Integer id);

    UserInfoResponse getUserInfoByBlog(Integer id);
}
