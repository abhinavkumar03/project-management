package com.abhinav.service;

import com.abhinav.exception.IssueException;
import com.abhinav.exception.UserException;
import com.abhinav.model.Comment;
import com.abhinav.model.Issue;
import com.abhinav.model.User;
import com.abhinav.repository.CommentRepository;
import com.abhinav.repository.IssueRepository;
import com.abhinav.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private IssueRepository issueRepository;
    private UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, IssueRepository issueRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Comment createComment(Long issueId, Long userId, String content) throws UserException, IssueException {
        Optional<Issue> issueOptional = issueRepository.findById(issueId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (issueOptional.isEmpty()){
            throw new IssueException("issue not found with id "+issueId);
        }
        if(userOptional.isEmpty()){
            throw new UserException("user not found with id "+userId);
        }
            Issue issue = issueOptional.get();
            User user = userOptional.get();

            Comment comment = new Comment();

            comment.setIssue(issue);
            comment.setUser(user);
            comment.setCreatedDateTime(LocalDateTime.now());
            comment.setContent(content);

            Comment savedComment = commentRepository.save(comment);

            issue.getComments().add(savedComment);

            return savedComment;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) throws UserException, IssueException {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (commentOptional.isEmpty()){
            throw new IssueException("comment not found with id "+commentId);
        }
        if(userOptional.isEmpty()){
            throw new UserException("user not found with id "+userId);
        }

        Comment comment = commentOptional.get();
        User user = userOptional.get();

        if (comment.getUser().equals(user)) {
            commentRepository.delete(comment);
        } else {
            throw new UserException("User does not have permission to delete this comment!");
        }

    }

    @Override
    public List<Comment> findCommentByIssueId(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }
}
