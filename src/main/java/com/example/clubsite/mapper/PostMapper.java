package com.example.clubsite.mapper;

import com.example.clubsite.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll(@Param("category") String category);
    List<Post> findByAuthorId(@Param("authorId") Long authorId);
    List<Post> findByFavoritedUsers(@Param("userId") Long userId);
    Post findById(Long id);
    void insert(Post post);
}
