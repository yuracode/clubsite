package com.example.clubsite.mapper;

import com.example.clubsite.model.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ScheduleMapper {
    List<Schedule> findByYearAndMonth(@Param("year") int year, @Param("month") int month);
    List<Schedule> findByDate(@Param("date") LocalDate date);
    void insert(Schedule schedule);
}
