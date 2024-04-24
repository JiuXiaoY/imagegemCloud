package com.imagegem.cloud.common;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/11
 */
public enum Errorcode {

    SUCCESS(0,"ok",""),
    PARAMS_ERROR(4000,"请求参数错误",""),
    SYSTEM_ERROR(50000,"系统内部异常","");

    ;
    private final int code;
    private final String message;
    private final String description;

    Errorcode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
