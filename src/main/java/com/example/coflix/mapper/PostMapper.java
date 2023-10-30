package com.example.coflix.mapper;

import com.example.coflix.dto.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("SELECT id,name,content FROM posts")
    List<Post> findAll();

    Post selectPost(int id);


    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findById(int id);

    @Insert("INSERT INTO posts(name, password, content) VALUES(#{name}, #{password}, #{content})")
    void insertPost(Post post);

    @Update("UPDATE posts SET name = #{name}, content = #{content} WHERE id = #{id} AND password = #{password}")
    int updatePost(Post post);

    @Delete("DELETE FROM posts WHERE id = #{id} AND password = #{password}")
    int deletePost(@Param("id") int id, @Param("password") String password);
}
