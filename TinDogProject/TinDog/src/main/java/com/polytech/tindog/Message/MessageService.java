package com.polytech.tindog.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message createMessage(String senderId, String receiverId, String messageBody) throws Exception {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Message message = new Message(senderId, receiverId, messageBody, date);
        return messageRepository.save(message);
    }

    public Message findLatestMessage(String senderId, String receiverId){
        Message temp1 = messageRepository.findFirstBySenderIdAndReceiverIdOrderByCreateDateAsc(senderId,receiverId).get();
        Message temp2 = messageRepository.findFirstBySenderIdAndReceiverIdOrderByCreateDateAsc(receiverId,senderId).get();
        if(temp1.getCreateDate().after(temp2.getCreateDate()))
            return temp1;
        else
            return temp2;
    }

    public List<MessageDto> findAllMessages(String senderId, String receiverId){
        List<Message> senderToReceiver = messageRepository.findBySenderIdAndReceiverId(senderId, receiverId).get();
        List<Message> receiverToSender = messageRepository.findBySenderIdAndReceiverId(receiverId, senderId).get();
        List<MessageDto> all = new ArrayList<MessageDto>();
        for(Message messageSender:senderToReceiver){
            MessageDto temp = new MessageDto(messageSender.getMessageBody(),messageSender.getCreateDate(),true);
            all.add(temp);
        }
        for(Message messageReceiver:receiverToSender){
            MessageDto temp = new MessageDto(messageReceiver.getMessageBody(),messageReceiver.getCreateDate(),false);
            all.add(temp);
        }
        all.sort(Comparator.comparing(MessageDto::getCreateDate));
        return all;
    }
}
