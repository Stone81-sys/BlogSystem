package org.example.blogssystem.common.utils;

import org.example.blogssystem.pojo.dataObject.BlogInfo;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanTransfer {

    public static BlogInfoResponse transf(BlogInfo blogInfoList){
        BlogInfoResponse blogInfoResponse=new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfoList,blogInfoResponse);
        return blogInfoResponse;
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
