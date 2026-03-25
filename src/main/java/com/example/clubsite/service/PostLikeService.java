package com.example.clubsite.service;

import com.example.clubsite.mapper.PostLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeMapper postLikeMapper;

    public void toggle(Long userId, Long postId) {
        if (postLikeMapper.exists(userId, postId)) {
            postLikeMapper.delete(userId, postId);
        } else {
            postLikeMapper.insert(userId, postId);
        }
    }

    public Set<Long> getLikedPostIds(Long userId) {
        return new HashSet<>(postLikeMapper.findPostIdsByUserId(userId));
    }

    public int getLikeCount(Long postId) {
        return postLikeMapper.countByPostId(postId);
    }
}
