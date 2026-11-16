package org.example.blogssystem.pojo.dataObject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfo {
//`id` INT NOT NULL AUTO_INCREMENT,
//`user_name` VARCHAR ( 128 ) NOT NULL,
//`password` VARCHAR ( 128 ) NOT NULL,
//`github_url` VARCHAR ( 128 ) NULL,
//`delete_flag` TINYINT ( 4 ) NULL DEFAULT 0,
// `create_time` DATETIME DEFAULT now(),

    @TableId(value = "id",type = IdType.AUTO)
    int id;
    String userName;
    String password;
    String githubUrl;
    Integer deleteFlag;
    LocalDateTime createTime;
    LocalDateTime updateTime;

}
