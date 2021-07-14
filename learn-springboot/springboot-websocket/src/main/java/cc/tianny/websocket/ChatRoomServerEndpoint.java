package cc.tianny.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static cc.tianny.websocket.utils.WebSocketUtils.ONLINE_USER_SESSIONS;
import static cc.tianny.websocket.utils.WebSocketUtils.sendMessageAll;


/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/14
 * Time: 5:05 下午
 * Description: No Description
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomServerEndpoint.class);

    /**
     * 建立连接的回调方法
     *
     * @param session  与客户端的WebSocket连接会话
     * @param username 用户名，WebSocket支持路径参数
     */
    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室";
        logger.info("用户登录: " + message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        logger.info("发送消息: " + message);
        sendMessageAll("用户 [" + username + "]: " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        // 移除当前 session
        ONLINE_USER_SESSIONS.remove(username);
        // 并且通知其他人当前用户已经离开聊天室了
        sendMessageAll("用户 [" + username + "] 已经离开聊天室了");
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onClose Error", e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onError Exception", e);
        }
        logger.info("Throwable msg " + throwable.getMessage());
    }

}
