package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.service.ServerBaseDemoService;
import lynu.chaohl.SpringbootIntegration.common.BaseResult;
import lynu.chaohl.SpringbootIntegration.common.log.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "微服务后端基础流程测试: springboot+mybatis+mysql")
@Slf4j
@RequestMapping("ServerBaseDemo")
public class ServerBaseDemoController {

    @Autowired
    private ServerBaseDemoService serverBaseDemoService;

    @OperationLog(apiName = "这是一个swagger的Demo测试")
    @ApiOperation("这是一个swagger的Demo测试")
    @PostMapping("/insert")
    public BaseResult<String> insert(@RequestBody ServerBaseDemo sbd){

        if (serverBaseDemoService.insert(sbd)!=0)
        log.info("hello world");

        return BaseResult.success("hello world");
    }
}
