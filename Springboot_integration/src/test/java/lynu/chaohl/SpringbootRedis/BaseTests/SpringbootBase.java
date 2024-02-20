package lynu.chaohl.SpringbootRedis.BaseTests;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.SpringbootIntegrationApplication;
import lynu.chaohl.SpringbootIntegration.websocket.service.WebSocketInvokeService;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
//以classes为入口做测试启动类，
@SpringBootTest(classes = SpringbootBase.class)
public class SpringbootBase {

        @Value("${auto.field.title}")
        private String title;

        @Value("${auto.field.desc}")
        private String desc;

        @Value("${auto.field.randomValue}")
        private String randomValue;


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
    }

//    获取yml配置文件值的测试
    @Test
    public void getYmlValueTest(){

    log.info("title:"+title+";desc:"+desc+";randomValue:"+randomValue);

    }
}
