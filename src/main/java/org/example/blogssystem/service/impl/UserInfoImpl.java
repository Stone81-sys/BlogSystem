package org.example.blogssystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.blogssystem.common.constants.Constants;
import org.example.blogssystem.common.exception.BlogException;
import org.example.blogssystem.common.utils.JwtUtil;
import org.example.blogssystem.mapper.UserMapper;
import org.example.blogssystem.pojo.dataObject.UserInfo;
import org.example.blogssystem.pojo.request.UserInfoRequest;
import org.example.blogssystem.pojo.response.UserInfoResponse;
import org.example.blogssystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo judgeUserInfo(UserInfoRequest userInfoRequest) {
        UserInfo userInfo=null;
        userInfo=userMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserName,userInfoRequest.getUserName())
                .eq(UserInfo::getDeleteFlag, Constants.UNDELETE)
        );
        return userInfo;
    }

    @Override
    public UserInfoResponse login(UserInfoRequest userInfoRequest) {
        UserInfo userInfo=judgeUserInfo(userInfoRequest);
        if(userInfo==null||userInfo.getId()<0){
            throw new BlogException("用户不存在");
        }
        if(!userInfo.getPassword().equals(userInfoRequest.getPassword())){
            throw new BlogException("用户或密码错误");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("name",userInfo.getUserName());
        String jwt=JwtUtil.genJwt(map);

        return new UserInfoResponse(userInfo.getId(),jwt);
    }
}
