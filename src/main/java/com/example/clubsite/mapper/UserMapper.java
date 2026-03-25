package com.example.clubsite.mapper;

import com.example.clubsite.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findById(Long id);
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void insert(User user);
    void update(User user);
}
