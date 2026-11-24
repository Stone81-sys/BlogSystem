package org.example.blogssystem.pojo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

@Slf4j
@Data
public class BlogUpdateRequest {
    @NotNull
    Integer id;
    @Length(max=100,message = "标题不能超过100")
    String title;
    String content;
}
