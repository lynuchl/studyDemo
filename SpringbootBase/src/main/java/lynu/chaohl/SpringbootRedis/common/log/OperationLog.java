package lynu.chaohl.SpringbootRedis.common.log;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

/**
 * <p>
 *    logger.info, 记日志文件, 非记到数据库log表中
 * </p>
 * Date: 2022/10/11 <br>
 * Author: xz <br>
 */
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface OperationLog {
    /**
     * 资源名称
     * @return
     */
    String apiName() default "";
}

