package lynu.chaohl.SpringbootRedis.BaseTests;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootBase.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootBase.ServerBaseDemo.service.ServerBaseDemoService;
import lynu.chaohl.SpringbootBase.SpringbootBaseApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import org.junit.jupiter.api.Test;

@Slf4j
@RunWith(SpringRunner.class)
//启动类做测试入口，也意味着整个项目会启动
@SpringBootTest(classes = SpringbootBaseApplication.class)
public class SpringbootBaseCopy {

        @Value("${auto.field.title}")
        private String title;

        @Value("${auto.field.desc}")
        private String desc;

        @Value("${auto.field.randomValue}")
        private String randomValue;

        @Autowired
        private ServerBaseDemoService serverBaseDemoService;



    @Test
    public void Test1(){
        System.out.println("hello Test1");

        ServerBaseDemo serverBaseDemo = serverBaseDemoService.selectByPrimaryKey(1);

        log.info(serverBaseDemo.toString());

    }

//    获取yml配置文件值的测试
    @Test
    public void getYmlValueTest(){

    log.info("title:"+title+";desc:"+desc+";randomValue:"+randomValue);
    }

    @Test
    public void indexTest(){


//        for (int i=0;i<10000;i++){
//
//            ServerBaseDemo serverBaseDemo =new ServerBaseDemo();
////            serverBaseDemo.setId(i);
//            serverBaseDemo.setTestid(i);
//            serverBaseDemo.setTestname("chaohl"+i);
//
//            serverBaseDemoService.insert(serverBaseDemo);
//
//            System.out.println("执行的顺序："+i);
//        }





    }
}
