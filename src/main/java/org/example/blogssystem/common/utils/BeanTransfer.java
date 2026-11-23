package org.example.blogssystem.common.utils;

import org.example.blogssystem.pojo.dataObject.BlogInfo;
import org.example.blogssystem.pojo.dataObject.UserInfo;
import org.example.blogssystem.pojo.request.BlogIssueRequest;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.example.blogssystem.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanTransfer {

    public static BlogInfoResponse transf(BlogInfo blogInfoList){
        BlogInfoResponse blogInfoResponse=new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfoList,blogInfoResponse);
        return blogInfoResponse;
    }

    public static UserInfoResponse transf(UserInfo userInfoList){
        UserInfoResponse userInfoResponse=new UserInfoResponse();
        BeanUtils.copyProperties(userInfoList,userInfoResponse);
        return userInfoResponse;
    }

    public static BlogInfo transf(BlogIssueRequest blogIssueRequest){
        BlogInfo blogInfo=new BlogInfo();
        BeanUtils.copyProperties(blogIssueRequest,blogInfo);
        return blogInfo;
    }
//    public static List<BlogInfoResponse> BIRList(List<BlogInfo> blogInfoList){
//        List<BlogInfoResponse> blogInfoResponseList=blogInfoList.stream()
//                .map(blogInfo->{
//                    BlogInfoResponse blogInfoResponse=new BlogInfoResponse();
//                    BeanUtils.copyProperties(blogInfo,blogInfoResponse);
//                    return blogInfoResponse;
//                })
//                .collect(Collectors.toList());
//
//        return blogInfoResponseList;
//    }
}
