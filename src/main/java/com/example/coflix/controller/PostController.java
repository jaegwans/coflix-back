package com.example.coflix.controller;

import com.example.coflix.dto.Post;
import com.example.coflix.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.insertPost(post);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody Post post) {
        post.setId(id);
        postService.updatePost(id,post);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id, @RequestParam String password) {
        return postService.deletePost(id, password);
    }
}
