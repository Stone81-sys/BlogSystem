package org.example.blogssystem.service;

import org.example.blogssystem.pojo.dataObject.UserInfo;
import org.example.blogssystem.pojo.request.UserInfoRequest;
import org.example.blogssystem.pojo.response.UserInfoResponse;

public interface UserInfoService {

    UserInfo judgeUserInfo(UserInfoRequest userInfoRequest);

    UserInfoResponse login(UserInfoRequest userInfoRequest);
}
