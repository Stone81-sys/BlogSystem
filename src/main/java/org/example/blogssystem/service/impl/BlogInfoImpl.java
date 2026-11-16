package org.example.blogssystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.blogssystem.common.constants.Constants;
import org.example.blogssystem.common.utils.BeanTransfer;
import org.example.blogssystem.mapper.BlogMapper;
import org.example.blogssystem.pojo.dataObject.BlogInfo;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.example.blogssystem.service.BlogInfoList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogInfoImpl implements BlogInfoList {
    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<BlogInfoResponse> getBlogList() {
        List<BlogInfo> blogInfoList= blogMapper.selectList(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getDeleteFlag, Constants.UNDELETE)
                .orderByDesc(BlogInfo::getId)
        );

        return BeanTransfer.BIRList(blogInfoList);
    }
}























