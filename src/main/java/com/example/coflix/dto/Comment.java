package com.example.coflix.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Comment {
    private Integer id;
    private Integer postId;
    private String name;
    private String password;
    private String content;
    // getter and setter methods
}
