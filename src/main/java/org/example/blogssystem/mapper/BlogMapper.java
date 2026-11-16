package org.example.blogssystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.blogssystem.pojo.dataObject.BlogInfo;

@Mapper
public interface BlogMapper extends BaseMapper<BlogInfo> {
}
