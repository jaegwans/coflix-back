package com.example.coflix.service;

import com.example.coflix.dto.Comment;
import com.example.coflix.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public boolean isPasswordCorrect(int commentId, String inputPassword) {
        Comment comment = commentMapper.selectComment(commentId);
        return comment.getPassword().equals(inputPassword);
    }


    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Transactional
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    public Optional<Comment> selectComment(int id) {
        return Optional.ofNullable(commentMapper.selectComment(id));
    }

    @Transactional
    public void updateComment(Comment comment, String inputPassword) {
        if (!isPasswordCorrect(comment.getId(), inputPassword)) {
            throw new IllegalArgumentException("Incorrect password");
        }
        commentMapper.updateComment(comment);
    }

    @Transactional
    public void deleteComment(int id, String inputPassword) {
        if (!isPasswordCorrect(id, inputPassword)) {
            throw new IllegalArgumentException("Incorrect password");
        }
        commentMapper.deleteComment(id);
    }

}
