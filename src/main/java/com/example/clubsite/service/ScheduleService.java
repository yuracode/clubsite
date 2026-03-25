package com.example.clubsite.service;

import com.example.clubsite.mapper.ScheduleMapper;
import com.example.clubsite.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleMapper scheduleMapper;

    public List<Schedule> findByYearAndMonth(int year, int month) {
        return scheduleMapper.findByYearAndMonth(year, month);
    }

    public List<Schedule> findByDate(LocalDate date) {
        return scheduleMapper.findByDate(date);
    }

    public void save(LocalDate date, String title, String detail, Long userId) {
        Schedule schedule = new Schedule();
        schedule.setDate(date);
        schedule.setTitle(title);
        schedule.setDetail(detail);
        schedule.setUserId(userId);
        scheduleMapper.insert(schedule);
    }
}
