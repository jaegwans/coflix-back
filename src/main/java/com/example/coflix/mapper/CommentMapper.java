package com.example.coflix.mapper;

import com.example.coflix.dto.Comment;
import org.apache.ibatis.annotations.*;

public interface CommentMapper {

    @Insert("INSERT INTO comments (post_id, name, password, content) VALUES (#{postId}, #{name}, #{password}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertComment(Comment comment);

    @Select("SELECT * FROM comments WHERE id = #{id}")
    @Results(id = "CommentResult", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "content", property = "content")
    })
    Comment selectComment(int id);

    @Update("UPDATE comments SET name = #{name}, password = #{password}, content = #{content} WHERE id = #{id}")
    void updateComment(Comment comment);

    @Delete("DELETE FROM comments WHERE id = #{id}")
    void deleteComment(int id);
}
