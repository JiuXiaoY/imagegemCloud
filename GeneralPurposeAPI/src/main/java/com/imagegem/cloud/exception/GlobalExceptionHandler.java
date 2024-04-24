package com.imagegem.cloud.exception;

import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.Errorcode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author JXY
 * @version 1.0
 * @since 2023/10/14
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("BusinessException" + e.getMessage(), e);
        return BaseResponse.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return BaseResponse.error(Errorcode.SYSTEM_ERROR, e.getMessage(), "fail to get");
    }

}
