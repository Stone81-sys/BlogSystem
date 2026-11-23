package org.example.blogssystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.blogssystem.common.constants.Constants;
import org.example.blogssystem.common.utils.BeanTransfer;
import org.example.blogssystem.mapper.BlogMapper;
import org.example.blogssystem.pojo.dataObject.BlogInfo;
import org.example.blogssystem.pojo.request.BlogIssueRequest;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.example.blogssystem.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<BlogInfoResponse> getBlogList() {
        List<BlogInfo> blogInfoList= blogMapper.selectList(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getDeleteFlag, Constants.UNDELETE)
                .orderByDesc(BlogInfo::getId)
        );

        List<BlogInfoResponse> blogInfoResponseList=blogInfoList.stream()
                .map(blogInfo->{
                    return BeanTransfer.transf(blogInfo);
                })
                .collect(Collectors.toList());

        return blogInfoResponseList;

    }

    @Override
    public BlogInfoResponse searchBlogDetails(int id) {
        BlogInfo blogInfoList=blogMapper.selectOne(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getId,id)
                .eq(BlogInfo::getDeleteFlag,Constants.UNDELETE)
        );
        return BeanTransfer.transf(blogInfoList);
    }

    @Override
    public Boolean addBlog(BlogIssueRequest blogIssueRequest) {
        BlogInfo blogInfo= BeanTransfer.transf(blogIssueRequest);
        Integer affectRows=blogMapper.insert(blogInfo);
        if(affectRows==0) {
            return false;
        }else if (affectRows!=0){
            return true;
        }
        return false;
    }
}























