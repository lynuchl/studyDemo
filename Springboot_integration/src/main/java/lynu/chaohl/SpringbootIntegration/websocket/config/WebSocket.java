/*
author:chaohl
*/
package lynu.chaohl.SpringbootIntegration.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

//    public String clientMessage;



    private Session session;
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    /*
     *
     * @param session
     * @Author chaohl
     * @Description 连接开启
     * @Date 16:23 2021/1/29
     * @return void
     **/
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        log.info("有新的连接,总数:" + webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        log.info("连接断开,当前总数" + webSockets.size());
    }

    /*
     *
     * @param message
     * @Author chaohl
     * @Description
     * @Date 16:25 2021/1/29
     * @return void
     **/
    @OnMessage
    public void onMessage(String message) {
        log.info("这个地方来了吗");
        log.info("message:"+message);

    }

    /*
     *
     * @param message 发送消息
     * @Author chaohl
     * @Description
     * @Date 16:28 2021/1/29
     * @return void
     **/
    public void sendMessage(String jsonString) {

//        log.info("this is diaoyogn");
        for (WebSocket webSocket : webSockets) {
                log.info("这里呢");
            try {

                webSocket.session.getBasicRemote().sendText("这里呢");
            }catch (Exception e){

            }

                }

            }
}
