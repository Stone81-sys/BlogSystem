package org.example.blogssystem.controller;

import jakarta.validation.constraints.NotNull;
import org.example.blogssystem.pojo.request.BlogIssueRequest;
import org.example.blogssystem.pojo.request.BlogUpdateRequest;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.example.blogssystem.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/getList")
    public List<BlogInfoResponse> getlist(){
        return blogService.getBlogList();

    }

    @GetMapping("/getBlogDetail")
    public BlogInfoResponse searchBlogDetails(@NotNull(message = "不能为空") int id){

        return blogService.searchBlogDetails(id);
    }

    @PostMapping("/add")
    public Boolean addBlogIssue(@Validated @RequestBody BlogIssueRequest blogIssueRequest){
        return blogService.addBlog(blogIssueRequest);
    }

    @PostMapping("/delete")
    public Boolean deleteBlog(Integer blogId){
        return blogService.deleteBlog(blogId);
    }

    @PostMapping("/update")
    public Boolean updateBlog(@Validated @RequestBody BlogUpdateRequest blogUpdateRequest){

        return blogService.updateBlog(blogUpdateRequest);
    }

}
