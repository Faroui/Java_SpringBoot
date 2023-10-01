package ma.n7chat.n7chatservice.controller;

import ma.n7chat.n7chatservice.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class chatController {
    @Autowired
    private SimpMessagingTemplate simpmessagingTemplate; // to create Topic
    @MessageMapping("/message") // /app/message
    @SendTo("chatroom/public")
    private Message receivePublicMessage(@Payload Message message){
        return  message;
    }
    @MessageMapping("/private-message")
    public Message reivePrivateMessage(@Payload Message message){
        simpmessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);  // /user/ismail/private
        return message;
    }
}
