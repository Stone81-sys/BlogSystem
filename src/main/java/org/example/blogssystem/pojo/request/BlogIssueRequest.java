package org.example.blogssystem.pojo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

@Slf4j
@Data
public class BlogIssueRequest {
    @NotNull
    Integer userId;
    @NotBlank
    @Length(max=100,message = "标题不能超过100")
    String title;
    String content;
}
