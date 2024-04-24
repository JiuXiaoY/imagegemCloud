package com.imagegem.cloud.exception;

import com.imagegem.cloud.common.Errorcode;

import java.io.Serial;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/11
 */
public class BusinessException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 3812734693621321202L;
    private final int code;
    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(Errorcode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public BusinessException(Errorcode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
