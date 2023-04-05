package com.potato.common.result;

import lombok.Getter;

/**
 * ClassName: ResultCodeEnum
 * Package: com.potato.common.result
 * Description:
 *
 * @Author: ZhouJF
 * @Create: 2023/4/4 - 9:18 PM
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    ;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
