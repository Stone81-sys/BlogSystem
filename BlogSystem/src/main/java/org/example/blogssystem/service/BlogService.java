package org.example.blogssystem.service;

import org.example.blogssystem.pojo.request.BlogIssueRequest;
import org.example.blogssystem.pojo.request.BlogUpdateRequest;
import org.example.blogssystem.pojo.response.BlogInfoResponse;

import java.util.List;

public interface BlogService {
    List<BlogInfoResponse> getBlogList();

    BlogInfoResponse searchBlogDetails(int id);

    Boolean addBlog(BlogIssueRequest blogIssueRequest);

    Boolean deleteBlog(Integer blogId);

    Boolean updateBlog(BlogUpdateRequest blogUpdateRequest);
}
