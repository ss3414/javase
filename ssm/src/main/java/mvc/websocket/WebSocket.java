package mvc.websocket;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/*
 * Tomcat WebSocket
 * ①两种实现方式，一种继承WebSocketServlet类，一种@ServerEndpoint注解
 * 依赖分别是tomcat-catalina和tomcat-websocket
 * ②如果项目不使用Maven管理，手动引入catalina jar包，在Tomcat上运行时就会jar包冲突错误
 * */
@WebServlet(urlPatterns = {"/websocket"})
public class WebSocket extends WebSocketServlet {

    @Override
    protected StreamInbound createWebSocketInbound(String s, HttpServletRequest request) {
        WebSocketMessage webSocketMessage = new WebSocketMessage();
        return webSocketMessage;
    }

}
