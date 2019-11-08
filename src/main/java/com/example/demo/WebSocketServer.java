package com.example.demo;

/**
 * @Author: 111
 * @Date: 2019/6/25 0025 上午 10:57
 * @Description:
 */
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{name}")
@RestController
public class WebSocketServer {
    //存储客户端的连接对象,每个客户端连接都会产生一个连接对象
    private static ConcurrentHashMap<String,WebSocketServer> map=new ConcurrentHashMap();
    //每个连接都会有自己的会话
    private Session session;
    private String name;
    @OnOpen
    public void open(@PathParam("name") String name, Session session) throws IOException {
        map.put(name,this);
        System.out.println(name+"连接服务器成功");
        System.out.println("客户端连接个数:"+getConnetNum());
        this.session=session;
        this.name=name;
        session.getBasicRemote().sendText(name+"已上线");
    }
    @OnClose
    public void close() throws IOException {
//        map.get(name).session.getBasicRemote().sendText(name+"断开了服务器连接");
        map.remove(name);
        System.out.println(name+"断开了服务器连接");

    }
    @OnError
    public void error(Throwable error){
        error.printStackTrace();
        System.out.println(name+"出现了异常");
    }
    @OnMessage
    public void getMessage(String message) throws IOException {
        System.out.println("收到"+name+":"+message);
        System.out.println("客户端连接个数:"+getConnetNum());

        Set<Map.Entry<String, WebSocketServer>> entries = map.entrySet();
        for (Map.Entry<String, WebSocketServer> entry : entries) {
            if(!entry.getKey().equals(name)){//将消息转发到其他非自身客户端
                entry.getValue().send(message);
            }
        }
    }

    public void send(String message) throws IOException {
        if(session.isOpen()){
            session.getBasicRemote().sendText(message);
        }
    }

    public int  getConnetNum(){
        return map.size();
    }
}
