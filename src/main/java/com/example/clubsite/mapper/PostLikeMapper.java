package com.example.clubsite.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PostLikeMapper {
    boolean exists(@Param("userId") Long userId, @Param("postId") Long postId);
    void insert(@Param("userId") Long userId, @Param("postId") Long postId);
    void delete(@Param("userId") Long userId, @Param("postId") Long postId);
    int countByPostId(@Param("postId") Long postId);
    List<Long> findPostIdsByUserId(@Param("userId") Long userId);
}
