package com.polytech.tindog.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/send-message")
    public Message sendMessage(@RequestParam String senderId, @RequestParam String receiverId, @RequestParam String messageBody) throws Exception {
        return messageService.createMessage(senderId,receiverId,messageBody);
    }

    @GetMapping("/latest-message")
    public Message getLatestMessage(@RequestParam String senderId, @RequestParam String receiverId){
        return  messageService.findLatestMessage(senderId,receiverId);
    }

    @GetMapping("/conversation")
    public List<MessageDto> getConversation(@RequestParam String senderId, @RequestParam String receiverId){
        return  messageService.findAllMessages(senderId,receiverId);
    }
}
