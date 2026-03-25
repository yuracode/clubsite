package com.example.clubsite.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private String profileImage;
    private LocalDateTime createdAt;
}
