package com.abhinav.controller;

import com.abhinav.exception.ChatException;
import com.abhinav.exception.UserException;
import com.abhinav.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealTimeChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/chat/{groupId}")
    public Message sendToUser(@Payload Message message,

                              @DestinationVariable String groupId) throws UserException, ChatException {


        simpMessagingTemplate.convertAndSendToUser(groupId, "/private",
                message);



        return message;
    }



}
