package com.example.clubsite.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Tournament {
    private Long id;
    private String name;
    private Integer year;
    private Integer month;
    private String firstPlace;
    private String secondPlace;
    private String thirdPlace;
    private Integer myRank;
    private String myTeamName;
    private LocalDateTime createdAt;
}
