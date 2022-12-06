package lynu.chaohl.SpringbootIntegration.common.properties;

import lombok.extern.slf4j.Slf4j;
//import lynu.chaohl.SpringbootIntegration.common.annotationUse.ConditionalOnPropertyUse;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//使用properties配置类的方式加载properties属性的方法，不能直接加载多级字段，如需要加载，需要创建映射bean。
@Slf4j
@Configuration
public class PropertiesLoad {


    private Properties prop = new Properties();

    public void init() throws IOException {
        InputStream in = PropertiesLoad.class.getClassLoader().getResourceAsStream("application-data.yml");
        prop.load(in);
        in.close();
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

//    @Bean
//    public PropertiesLoad getPropertiesLoad(){
//
//        PropertiesLoad propertiesLoad=new PropertiesLoad();
//
//        try {
//            propertiesLoad.init();
//        }catch (IOException e){
//        }
////        propertiesLoad.getProperty("auto.field.name");
//
//        log.info("auto.field.name:"+propertiesLoad.getProperty("propertiesTest"));
//        return propertiesLoad;
//    }




}
