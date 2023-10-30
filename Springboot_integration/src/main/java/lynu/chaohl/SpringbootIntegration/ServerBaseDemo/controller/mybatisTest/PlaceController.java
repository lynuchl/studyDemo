package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.controller.mybatisTest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.County;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.Nation;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.service.mybatisTest.PlaceService;
import lynu.chaohl.SpringbootIntegration.common.HttpResp.BaseResult;
import lynu.chaohl.SpringbootIntegration.common.log.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "springboot+mybatis+mysql 测试")
@Slf4j
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @OperationLog(apiName = "mybatis测试")
    @ApiOperation("mybatis测试")
    @PostMapping("/insertCity")
    public BaseResult<String> insertCity(@RequestBody County record){

        if (placeService.insertCounty(record)==0)
            return BaseResult.fail("插入失败");


        return BaseResult.success("插入成功");
    }

    @ApiOperation("mybatis测试关系映射测试")
    @GetMapping("/getNations")
    public BaseResult<List<Nation>> getNations(){

        return BaseResult.success(placeService.getNations());
    }


}
