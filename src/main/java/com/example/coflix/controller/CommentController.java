package com.example.coflix.controller;

import com.example.coflix.dto.Comment;
import com.example.coflix.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        commentService.insertComment(comment);
    }

    @GetMapping("/{id}")
    public Optional<Comment> getComment(@PathVariable int id) {
        return commentService.selectComment(id);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable int id, @RequestBody Comment comment) {
        comment.setId(id);
        commentService.updateComment(comment,comment.getPassword());
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id,commentService.selectComment(id).get().getPassword());
    }
}
