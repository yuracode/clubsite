package com.example.clubsite.mapper;

import com.example.clubsite.model.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface FavoriteMapper {
    List<Favorite> findByUserId(Long userId);
    boolean exists(@Param("userId") Long userId, @Param("targetId") Long targetId);
    void insert(@Param("userId") Long userId, @Param("targetId") Long targetId);
    void delete(@Param("userId") Long userId, @Param("targetId") Long targetId);
}
