package org.example.blogssystem.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResultEnums {
    SUCCESS(200),
    FAIL(-1);

    @Getter
    private int code;
}
