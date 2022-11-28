package lynu.chaohl.SpringbootIntegration.websocket.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lynu.chaohl.SpringbootIntegration.websocket.service.WebSocketInvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api("websocket技术测试")
public class WebSocketInvokeController {


        @Autowired
        private WebSocketInvokeService webSocketInvokeService;


//不可这样调用接口，然后发送消息给接口。不然接口的请求不会被关闭，导致报错
//        @ApiOperation("/InvokeTest")
//        @PostMapping("/InvokeTest")
        public void InvokeTest(){

            webSocketInvokeService.InvokeTest();
        }
}
