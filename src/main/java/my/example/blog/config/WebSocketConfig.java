package my.example.blog.config;


import my.example.blog.chat.ChatSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    //WebSocketConfigurer를 구현하여 추가적인 설정을 한다.

    //WebSocketHandler를 추가한다.
    //1. 클라이언트가 접속을 했을 때 특정 메소드가 호출.
    //2. 클라이언트가 접속을 close했을 때 특정 메소드가 호출
    //3. 클라이언트가 메시지를 보냈을 때 특정 메소드 호출출


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new ChatSocketHandler(),"/ws").withSockJS();
    }
}
