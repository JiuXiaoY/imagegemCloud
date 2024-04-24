package com.imagegem.cloud.common;

import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/11
 */
@SuppressWarnings("all")
/**
 * <T>：这是一个类型参数的声明，表明这是一个泛型方法。它告诉编译器，方法中使用的 T 是一个占位符类型，在调用该方法时会被实际的类型替代。
 * BaseResponse<T>：这是方法的返回类型。BaseResponse<T> 表示一个具有泛型参数 T 的 BaseResponse 类型。
 * 这意味着该方法返回的 BaseResponse 对象可以包含任意类型的数据，具体类型由调用该方法时传入的类型决定。
 */
public class ResultUtils {
    /**
     * 成功
     *
     * @param data 值
     * @param <T>  泛型
     * @return 状态
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 为了防止大改动，这里先返回集合第一条数据
     *
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> success(List<T> data) {
        return new BaseResponse<>(0, data.get(1), "ok");
    }

    /**
     * 失败
     *
     * @param errorCode 失败信息
     * @return 基本响应
     */
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
