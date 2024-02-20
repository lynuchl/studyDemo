package lynu.chaohl.SpringbootRedis.BaseTests;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.mapper.mybatisTest.CityMapper;
import lynu.chaohl.SpringbootIntegration.SpringbootIntegrationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

//import org.junit.jupiter.api.Test;

@Slf4j
@RunWith(SpringRunner.class)
//启动类做测试入口，也意味着整个项目会启动
@SpringBootTest(classes = SpringbootIntegrationApplication.class)
public class SpringbootBaseCopy {

        @Value("${auto.field.title}")
        private String title;

        @Value("${auto.field.desc}")
        private String desc;

        @Value("${auto.field.randomValue}")
        private String randomValue;

        @Resource
        private CityMapper cityMapper;


//        @Autowired
//        private WebSocketInvokeService webSocketInvokeService=new WebSocketInvokeService();
//
//        @Test
//        public void InvokeTest(){
//
//            webSocketInvokeService.InvokeTest();
//        }

    @Test
    public void Test1(){
        System.out.println("hello Test1");
        log.info(cityMapper.toString());
    }

//    获取yml配置文件值的测试
    @Test
    public void getYmlValueTest(){

    log.info("title:"+title+";desc:"+desc+";randomValue:"+randomValue);

    }
}
