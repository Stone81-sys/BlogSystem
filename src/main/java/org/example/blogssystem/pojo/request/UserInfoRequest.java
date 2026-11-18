package org.example.blogssystem.pojo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserInfoRequest {
    @Length(max=20,message = "用户名称不能超过20")
    @NotBlank(message = "用户名不能为空")
    String userName;
    @Length(max=20,message = "密码长度不能超过20")
    @NotBlank(message = "密码不能为空")
    String password;
}
