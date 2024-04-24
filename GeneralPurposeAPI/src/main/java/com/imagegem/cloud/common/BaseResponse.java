package com.imagegem.cloud.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/11
 */
@Data
@NoArgsConstructor
@SuppressWarnings("all")
public class BaseResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 46515003643787041L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 数据
     */
    private T data;

    /**
     * 响应码描述
     */
    private String message;

    /**
     * 响应码描述（详情）
     */
    private String description;

    /**
     * 定义一些接受的构造函数，即语法糖
     *
     * @param code        (可选)
     * @param data        (可选)
     * @param message     (可选)
     * @param description (可选)
     */


    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    /**
     * 为了防止大改动，这里先返回集合第一条数据
     *
     * @param code
     * @param data
     */
    public BaseResponse(int code, List<T> data) {
        this(code, data.get(1), "", "");
    }

    public BaseResponse(Errorcode errorcode) {
        this(errorcode.getCode(), null, errorcode.getMessage(), errorcode.getDescription());
    }


    /**
     * test
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse(0,data,"ok");
    }

    public static <T> BaseResponse<T> success(List<T> data) {
        return new BaseResponse<>(0, data.get(1), "ok");
    }

    public static <T> BaseResponse error(Errorcode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static <T> BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    public static <T> BaseResponse error(Errorcode errorcode, String message, String description) {
        return new BaseResponse(errorcode.getCode(),null,message,description);
    }
}
