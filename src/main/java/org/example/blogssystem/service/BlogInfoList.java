package org.example.blogssystem.service;

import org.example.blogssystem.pojo.response.BlogInfoResponse;

import java.util.List;

public interface BlogInfoList {
    List<BlogInfoResponse> getBlogList();
}
