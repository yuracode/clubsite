package com.example.clubsite.service;

import com.example.clubsite.mapper.FavoriteMapper;
import com.example.clubsite.model.Favorite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteMapper favoriteMapper;

    public List<Favorite> findByUserId(Long userId) {
        return favoriteMapper.findByUserId(userId);
    }

    public boolean isFavorited(Long userId, Long targetId) {
        return favoriteMapper.exists(userId, targetId);
    }

    public void toggleFavorite(Long userId, Long targetId) {
        if (favoriteMapper.exists(userId, targetId)) {
            favoriteMapper.delete(userId, targetId);
        } else {
            favoriteMapper.insert(userId, targetId);
        }
    }
}
