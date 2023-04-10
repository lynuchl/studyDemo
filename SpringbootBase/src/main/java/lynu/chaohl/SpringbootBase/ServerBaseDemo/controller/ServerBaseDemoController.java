package lynu.chaohl.SpringbootBase.ServerBaseDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootBase.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootBase.ServerBaseDemo.service.ServerBaseDemoService;
import lynu.chaohl.SpringbootBase.common.BaseResult;
import lynu.chaohl.SpringbootBase.common.log.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@Api(tags = "微服务后端基础流程测试: springboot+mybatis+mysql")
@Slf4j
@RequestMapping("ServerBaseDemo")
public class ServerBaseDemoController {

    @Autowired
    private ServerBaseDemoService serverBaseDemoService;

    @OperationLog(apiName = "这是一个swagger的Demo测试")
    @ApiOperation("Restful风格,Post请求，实体映射")
    @PostMapping("/Restful/insert")
    public BaseResult<String> insert(@RequestBody ServerBaseDemo sbd){

        if (serverBaseDemoService.insert(sbd)!=0)
        log.info("hello world");

        return BaseResult.success("hello world");
    }

    @OperationLog(apiName = "这是一个swagger的Demo测试")
    @ApiOperation("这是二个swagger的Demo测试")
    @PostMapping("/indexTest")
    public BaseResult<String> indexTest(String name){

//        for (int i=0;i<10000;i++){
//
//            ServerBaseDemo serverBaseDemo =new ServerBaseDemo();
//            serverBaseDemo.setId(i+1);
//            serverBaseDemo.setTestid(i+1);
//            serverBaseDemo.setTestname("chaohl"+i);
//
//            serverBaseDemoService.insert(serverBaseDemo);
//
//            System.out.println("执行的顺序："+i);
//        }
        Date startDate=new Date();
        serverBaseDemoService.selectByName(name);
        Date endDate=new Date();
        Long time=endDate.getTime()-startDate.getTime();
        log.info(Long.toString(time));

        return BaseResult.success("hello world");
    }

    @OperationLog(apiName = "这是一个swagger的Demo测试")
    @ApiOperation("这是三个swagger的Demo测试")
    @PostMapping("/indexTest3")
    public BaseResult<String> insertIndexTest(){

            ServerBaseDemo serverBaseDemo =new ServerBaseDemo();

        for (int i=0;i<20000000;i++){

            serverBaseDemo.setId(i+1);
            serverBaseDemo.setTestid(i+1);
            serverBaseDemo.setTestname("chaohl"+i);

            serverBaseDemoService.insert(serverBaseDemo);

            System.out.println("执行的顺序："+i);
        }
//        Date startDate=new Date();
//        serverBaseDemoService.selectByName(name);
//        Date endDate=new Date();
//        Long time=endDate.getTime()-startDate.getTime();
//        log.info(Long.toString(time));

        return BaseResult.success("hello world");
    }

    @GetMapping(value = "/Restful/{id}")
    @ApiOperation("Restful风格，单多参一样，get请求，@PathVariable")
    public BaseResult<ServerBaseDemo> findById(@PathVariable Integer id) {

        return BaseResult.success("以“/”方式来获取参数值");
    }

    @GetMapping(value = "/Restful")
    @ApiOperation("Restful风格，单多参一样，get请求")
    public BaseResult<ServerBaseDemo> findByIdByParam(@PathParam("ID") Integer id) {

        return BaseResult.success("@PathParam\n" +
                "它是以键值对方式来获取参数值的。\n" +
                "这个注解相对简单，就是从地址栏取参数值，采用的是传统的拼接参数方法");
    }

    @DeleteMapping(value = "/{id}")
    public BaseResult<ServerBaseDemo> delete(@PathVariable Long id) {
        return BaseResult.success("hello world");
    }

    @PutMapping(value = "/{id}")
    public BaseResult<ServerBaseDemo> update(@PathVariable Long id, @RequestBody ServerBaseDemo bean) {
        return BaseResult.success("hello world");
    }

}
