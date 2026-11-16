package org.example.blogssystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.blogssystem.pojo.dataObject.UserInfo;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

}
