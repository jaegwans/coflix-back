package com.example.coflix.service;

import com.example.coflix.dto.Post;
import com.example.coflix.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final PostMapper postMapper;

    public boolean checkPassword(int id, String password) {
        Post post = postMapper.findById(id);
        return post != null && post.getPassword().equals(password);
    }

    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postMapper.findAll();
        Collections.reverse(posts);
        return posts;
    }


    public Post findById(int id) {
        return postMapper.selectPost(id);
    }

    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }

    public int updatePost(int id, Post post) {
        if (checkPassword(id, post.getPassword())) {
            return postMapper.updatePost(post);
        }
        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }

    public int deletePost(int id, String password) {
        if (checkPassword(id, password)) {
            return postMapper.deletePost(id, password);
        }
        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }
}
