package lynu.chaohl.SpringbootIntegration.utils;

/**
 * <p>
 *    返回信息
 * </p>
 * Date: 2021/5/10 <br>
 * Author: lwm <br>
 */
public interface ICodeMsg {

    /**
     * 返回码
     */
    int getCode();

    /**
     * 错误信息, 可以用占位符的方式;
     * 比如: hello, {}, welcome, {};
     * {}为占位符
     */
    String getMsg();

}
