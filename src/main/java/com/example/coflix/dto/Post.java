package com.example.coflix.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
    private int id;
    private String name;
    private String password;
    private String content;
    private List<Comment> comments;

}
