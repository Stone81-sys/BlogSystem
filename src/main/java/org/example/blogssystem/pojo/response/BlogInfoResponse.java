package org.example.blogssystem.pojo.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogInfoResponse {
    Integer id;
    String title;
    String content;
    Integer deleteFlag;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    LocalDateTime updateTime;
}
