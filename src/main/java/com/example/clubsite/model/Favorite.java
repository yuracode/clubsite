package com.example.clubsite.model;

import lombok.Data;

@Data
public class Favorite {
    private Long id;
    private Long userId;
    private Long targetId;
    private User target;
}
