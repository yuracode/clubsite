package com.example.clubsite.service;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findByNickname(String nickname) {
        return userMapper.findByNickname(nickname);
    }

    public Optional<User> findById(Long id) {
        return userMapper.findById(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public void register(String nickname, String email, String rawPassword, MultipartFile profileImage) throws IOException {
        User user = new User();
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));

        if (profileImage != null && !profileImage.isEmpty()) {
            String filename = UUID.randomUUID() + "_" + profileImage.getOriginalFilename();
            Path uploadDir = Paths.get("src/main/resources/static/uploads");
            Files.createDirectories(uploadDir);
            profileImage.transferTo(uploadDir.resolve(filename));
            user.setProfileImage("/uploads/" + filename);
        }
        userMapper.insert(user);
    }
}
