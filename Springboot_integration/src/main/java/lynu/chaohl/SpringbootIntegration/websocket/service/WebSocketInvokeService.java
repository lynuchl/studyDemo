package lynu.chaohl.SpringbootIntegration.websocket.service;

import lombok.extern.slf4j.Slf4j;
import lynu.chaohl.SpringbootIntegration.websocket.config.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebSocketInvokeService {


    @Autowired
    private WebSocket webSocket;

    public void InvokeTest(){

        log.info("执行");
    webSocket.sendMessage("hello world");
        log.info("执行");
    }
}
