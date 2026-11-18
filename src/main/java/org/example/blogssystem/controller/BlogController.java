package org.example.blogssystem.controller;

import jakarta.validation.constraints.NotNull;
import org.example.blogssystem.pojo.response.BlogInfoResponse;
import org.example.blogssystem.service.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogInfoService blogInfoService;

    @RequestMapping("/getList")
    public List<BlogInfoResponse> getlist(){
        return blogInfoService.getBlogList();

    }

    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse searchBlogDetails(@NotNull(message = "不能为空") int id){

        return blogInfoService.searchBlogDetails(id);
    }

}
