package com.example.clubsite.mapper;

import com.example.clubsite.model.Tournament;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface TournamentMapper {
    List<Tournament> findByYear(@Param("year") int year);
    List<Tournament> findAll();
    void insert(Tournament tournament);
}
