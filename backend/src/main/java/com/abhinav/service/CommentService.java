package com.abhinav.service;

import com.abhinav.exception.IssueException;
import com.abhinav.exception.UserException;
import com.abhinav.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId,Long userId,String comment) throws UserException, IssueException;

    void  deleteComment(Long commentId, Long userId) throws UserException, IssueException;

    List<Comment> findCommentByIssueId(Long issueId);

}
