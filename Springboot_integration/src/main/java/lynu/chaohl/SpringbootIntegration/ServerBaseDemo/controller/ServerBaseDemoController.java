package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.ServerBaseDemo;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.County;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.mybatisTest.City;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.service.ServerBaseDemoService;
import lynu.chaohl.SpringbootIntegration.common.HttpResp.BaseResult;
import lynu.chaohl.SpringbootIntegration.common.log.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "微服务后端基础流程测试: springboot+mybatis+mysql")
@Slf4j
@RequestMapping("ServerBaseDemo")
public class ServerBaseDemoController {

    @Autowired
    private ServerBaseDemoService serverBaseDemoService;


    @OperationLog(apiName = "这是一个swagger的Demo测试")
    @ApiOperation("${propertiesTest}")
    @PostMapping("/insert")
    public BaseResult<String> insert(@RequestBody ServerBaseDemo sbd){

        if (serverBaseDemoService.insert(sbd)!=0)
        log.info("hello world");

        return BaseResult.success("hello world");
    }

//    @OperationLog(apiName = "这是二个swagger的Demo测试")
//    @ApiOperation("这是二个swagger的Demo测试")
//    @PostMapping("/divPage")
//    public BaseResult<List<City>> divPage(@RequestBody Map<String,Integer> map){
//
//        List<City> cities=   serverBaseDemoService.divPage(map);
//
//
//        log.info(cities.toString());
////
//
//        return BaseResult.success(cities);
//    }

    @ApiOperation("文件上传")
    @PostMapping("/uploadFile")
    public BaseResult<Long> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null) {
            throw new RuntimeException("请选择需要上传的文件");
        }
        return BaseResult.success(serverBaseDemoService.uploadImage(file));
    }
}
