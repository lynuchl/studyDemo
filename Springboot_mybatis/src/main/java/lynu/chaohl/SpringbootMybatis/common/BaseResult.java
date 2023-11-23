package lynu.chaohl.SpringbootMybatis.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 响应信息类
 *
 * @param <T>
 * @author wangqingchun
 */
@ApiModel
@Data
public class BaseResult<T> {

    private static final Integer successCode = 1;
    private static final String successMsg = "success";
    private static final Integer failCode = 0;
    private static final String failMsg = "fail";

    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("业务码")
    private Integer errorCode;
    @ApiModelProperty("提示信息")
    private String msg;
    @ApiModelProperty("业务提示信息")
    private String dataMsg;
    @ApiModelProperty("数据对象")
    private T data;

    public static BaseResult fail(String msg) {
        return fail(failCode, msg);
    }

    public static BaseResult fail(Integer errorCode, String msg) {
        return fail(errorCode, msg, msg);
    }

    public static BaseResult fail(String msg, String dataMsg) {
        return fail(failCode, msg, dataMsg);
    }

    public static BaseResult fail(Integer errorCode, String msg, String dataMsg) {
        return baseResult(failCode, errorCode, msg, dataMsg, null);
    }

    public static <T> BaseResult success() {
        return success(successMsg);
    }

    public static <T> BaseResult success(T data) {
        return success(successMsg, successMsg, data);
    }

    public static <T> BaseResult<T> success(T data, String msg) {
        return success(msg, msg, data);
    }

    public static <T> BaseResult<T> success(String msg, T data) {
        return success(msg, msg, data);
    }

    public static <T> BaseResult<T> success(String msg, String dataMsg, T data) {
        return baseResult(successCode, null, msg, dataMsg, data);
    }

    private static <T> BaseResult<T> baseResult(Integer code, Integer errorCode, String msg, String dataMsg, T data) {
        return new BaseResult(code, errorCode, msg, dataMsg, data);
    }

    public BaseResult(Integer code, Integer errorCode, String msg, String dataMsg, T data) {
        this.code = code;
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
        this.dataMsg = dataMsg;
    }

}

