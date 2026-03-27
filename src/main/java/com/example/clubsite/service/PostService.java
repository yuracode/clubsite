package com.example.clubsite.service;

import com.example.clubsite.mapper.PostMapper;
import com.example.clubsite.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public List<Post> findAll(String category) {
        return postMapper.findAll(category);
    }

    public List<Post> findByAuthorId(Long authorId) {
        return postMapper.findByAuthorId(authorId);
    }

    public List<Post> findByFavoritedUsers(Long userId) {
        return postMapper.findByFavoritedUsers(userId);
    }

    public void createPost(String title, String content, String category, Long authorId, MultipartFile image) throws IOException {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCategory(category);
        post.setAuthorId(authorId);

        if (image != null && !image.isEmpty()) {
            String filename = UUID.randomUUID() + "_" + image.getOriginalFilename();
            Path uploadDir = Paths.get("uploads").toAbsolutePath();
            Files.createDirectories(uploadDir);
            image.transferTo(uploadDir.resolve(filename).toFile());
            post.setImageUrl("/uploads/" + filename);
        }
        postMapper.insert(post);
    }
}
