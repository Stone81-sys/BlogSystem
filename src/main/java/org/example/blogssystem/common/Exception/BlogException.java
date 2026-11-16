package org.example.blogssystem.common.Exception;

import lombok.Data;

@Data
public class BlogException extends RuntimeException{
    int code;
    String message;

    public BlogException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BlogException(String message) {
        this.message = message;
    }
}
