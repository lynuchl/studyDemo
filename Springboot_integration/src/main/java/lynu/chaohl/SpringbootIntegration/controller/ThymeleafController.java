package lynu.chaohl.SpringbootIntegration.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.common.log.OperationLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/thymeleafBaseDemo")
public class ThymeleafController {


    @OperationLog(apiName = "这是一个thymeleaf的测试")
    @ApiOperation("这是一个thymeleaf的测试")
    @RequestMapping("/thymeleaf")
    public String thymeleafTest(Model model){

        log.info("这是一个thymeleaf的测试");
        model.addAttribute("msg","这是一个thymeleaf的测试");

        return "test";
    }
}
