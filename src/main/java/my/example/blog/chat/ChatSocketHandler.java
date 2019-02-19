package my.example.blog.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.example.blog.security.BlogSecurityUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatSocketHandler extends TextWebSocketHandler {
    ObjectMapper objectMapper = new ObjectMapper();
    List<WebSocketSession> list = Collections.synchronizedList(new ArrayList<>());


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속 ========================");
        System.out.println(session.getId());
        System.out.println("접속 ========================");
        list.add(session);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println("메시지가 왔다.");
        System.out.println(session.getId() + "," + message.getPayload());
        System.out.println("메시지가 왔다.");
        AbstractAuthenticationToken principal = (AbstractAuthenticationToken) session.getPrincipal();
        BlogSecurityUser securityUser = (BlogSecurityUser) principal.getPrincipal();

        ChatMessage clientMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);


        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setName(securityUser.getName());
        chatMessage.setMessage(clientMessage.getMessage());
        String json = objectMapper.writeValueAsString(chatMessage);
        for (WebSocketSession wss : list) {
            wss.sendMessage(new TextMessage(json));
        }
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("접속 close =============");
        System.out.println(session.getId());
        System.out.println("접속 close =============");
        list.remove(session);

    }
}

