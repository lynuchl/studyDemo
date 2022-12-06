package lynu.chaohl.SpringbootIntegration.common.annotationUse;


import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.common.annotationUse.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
//此注解限制@bean是否被生效，当满足条件，也就是配置文件存在字段时，@Bean才生效
@ConditionalOnProperty(prefix="auto.field", name="name",havingValue = "chaohl")
public class ConditionalOnPropertyUse {


    @Bean
    public User getUser(){

        log.info("此处是否被加载");
//        log.info(""+ #{'${auto}'});
        return new User();
    }

}
