package com.example.clubsite.model;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Schedule {
    private Long id;
    private LocalDate date;
    private String title;
    private String detail;
    private LocalDateTime createdAt;
    private Long userId;
}
