package com.example.clubsite.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Post {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    private String category;
    private LocalDateTime createdAt;
    private Long authorId;
    private User author;

    public String getCategoryLabel() {
        try {
            return Category.valueOf(category).getLabel();
        } catch (Exception e) {
            return category;
        }
    }
}
