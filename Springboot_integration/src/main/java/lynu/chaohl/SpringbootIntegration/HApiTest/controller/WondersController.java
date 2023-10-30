package lynu.chaohl.SpringbootIntegration.HApiTest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.common.HttpResp.BaseResult;
import lynu.chaohl.SpringbootIntegration.common.log.OperationLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Api(tags = "厂商万达的业务逻辑")
@Slf4j
@RequestMapping("WondersIDemo")
public class WondersController {


    @ApiOperation("这是一个万达的接口Demo测试")
    @PostMapping("/firstDemoTest")
    public BaseResult<String> firstDemoTest(String name){

        Date startDate=new Date();
        Date endDate=new Date();
        Long time=endDate.getTime()-startDate.getTime();
        log.info(Long.toString(time)+"推送成功！！！");


        return BaseResult.success("hello world");
    }


}
