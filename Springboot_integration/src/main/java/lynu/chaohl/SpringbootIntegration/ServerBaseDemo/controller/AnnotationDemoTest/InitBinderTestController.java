package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.controller.AnnotationDemoTest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
//import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.InitBinderTest.User;
import lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity.InitBinderTest.UserTest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Api(tags = "InitBinder 注解测试")
@Slf4j
public class InitBinderTestController {


//    @InitBinder
//    public void bind(WebDataBinder webDataBinder){
//
//        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
//        CustomDateEditor customDateEditor=new CustomDateEditor(dateFormat,true);
//        webDataBinder.registerCustomEditor(Date.class,customDateEditor);
//    }

    @ApiOperation("InitBinderAnnotation 注解要点测试")
    @PostMapping("/initBinderAnnotationTest")
    public String InitBinderAnnotationTest( UserTest user){

        log.info("user.toString():"+user.toString());
        return user.toString();
    }

    @ApiOperation("InitBinderAnnotation 注解要点测试Get请求")
    @GetMapping("/initBinderAnnotationTest")
    public String GetInitBinderAnnotationTest(UserTest user){

        log.info("user.toString():"+user.toString());
        return user.toString();
    }



}
