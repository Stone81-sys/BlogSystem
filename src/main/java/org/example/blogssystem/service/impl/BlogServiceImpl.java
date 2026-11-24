package org.example.blogssystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.validation.constraints.NotNull;
import org.example.blogssystem.common.constants.Constants;
import org.example.blogssystem.common.exception.BlogException;
import org.example.blogssystem.common.utils.BeanTransfer;
import org.example.blogssystem.mapper.BlogMapper;
import org.example.blogssystem.pojo.dataObject.BlogInfo;
import org.example.blogssystem.pojo.request.BlogIssueRequest;
import org.example.blogssystem.pojo.request.BlogUpdateRequest;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.example.blogssystem.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
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

    @Override
    public Boolean deleteBlog(@NotNull(message = "不能为空") Integer blogId) {
        BlogInfo blogInfo=blogMapper.selectById(blogId);
        if(blogInfo==null||blogInfo.getDeleteFlag()==Constants.DELETE){
            throw new BlogException("该博客已不存在");
        }

        blogInfo.setDeleteFlag(Constants.DELETE);
        blogInfo.setUpdateTime(LocalDateTime.now());
        Integer rows=blogMapper.updateById(blogInfo);
        if(rows!=0){
            return true;
        }

        return false;
    }

    @Override
    public Boolean updateBlog(@Validated BlogUpdateRequest blogUpdateRequest) {
        BlogInfo blogInfo=BeanTransfer.transf(blogUpdateRequest);
        Integer rows=blogMapper.updateById(blogInfo);
        if(rows!=0){
            return true;
        }else {
            return false;
        }
    }

}























