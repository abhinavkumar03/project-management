package com.abhinav.service;

import java.util.List;

import com.abhinav.exception.ChatException;
import com.abhinav.exception.ProjectException;
import com.abhinav.exception.UserException;
import com.abhinav.model.Message;

public interface MessageService {

    Message sendMessage(Long senderId, Long chatId, String content) throws UserException, ChatException, ProjectException;

    List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException;
}

