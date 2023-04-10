package lynu.chaohl.SpringbootIntegration.utils;

/**
 * <p>
 *    基本返回码
 * </p>
 * Date: 2021/5/11 <br>
 * Author: lwm <br>
 */
public enum ApiCodeMsg implements ICodeMsg {
    SUCCESS(200, "success"),
    FAIL(500, "fail"),

    SIMPLE(600000, "`{}`"),

    NOT_NULL(600001, "`{}`can not be null"),
    NOT_EMPTY(600002, "`{}`can not be empty"),
    LENGTH(600003, "The length of `{}` must between`{}` and `{}`"),
    RANGE(600004, "The value of `{}` must between `{}` and `{}`"),
    LESS_EQUALS_THAN(600005, "{} should less and equals than {}"),
    GREATER_EQUALS_THAN(600006, "{} should greater and equals than {}"),

    REPEAT_SUBMIT(600007, "{}内不能重复提交"),
    ;

    private int code;

    private String msg;

    ApiCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}