package lynu.chaohl.SpringbootIntegration.utils;

import lombok.Getter;

/**
 * 自定义异常
 *
 * @author yangtao
 */
@Getter
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private String dataMessage;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(String message, String dataMessage) {
        this.message = message;
        this.code = code;
        this.dataMessage = dataMessage;
    }

    public CustomException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public CustomException(Integer code, String message, String dataMessage) {
        this(code, message, dataMessage, null);
    }

    public CustomException(String message, Throwable throwable) {
        this(ApiCodeMsg.FAIL.getCode(), message, null, throwable);
    }

    public CustomException(Integer code, String message, String dataMessage, Throwable throwable) {
        super(throwable);
        this.message = message;
        this.code = code;
        this.dataMessage = dataMessage;
    }

}
