package org.example.blogssystem.pojo.dataObject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("blog_info")
public class BlogInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;

    private LocalDateTime createTime;   // 原来写成了 createTlag（拼写错误）
    private LocalDateTime updateTime;
}
