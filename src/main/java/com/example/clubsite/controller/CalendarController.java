package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.Schedule;
import com.example.clubsite.model.User;
import com.example.clubsite.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    private final ScheduleService scheduleService;
    private final UserMapper userMapper;

    @GetMapping("/calendar")
    public String calendarPage(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "month", required = false) Integer month,
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {
        LocalDate today = LocalDate.now();
        int targetYear = (year != null) ? year : today.getYear();
        int targetMonth = (month != null) ? month : today.getMonthValue();

        YearMonth yearMonth = YearMonth.of(targetYear, targetMonth);
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();

        List<Schedule> monthSchedules = scheduleService.findByYearAndMonth(targetYear, targetMonth);
        List<Schedule> todaySchedules = scheduleService.findByDate(today);

        // Build a map of date -> schedule titles for calendar display
        Map<LocalDate, List<Schedule>> scheduleMap = new HashMap<>();
        for (Schedule s : monthSchedules) {
            scheduleMap.computeIfAbsent(s.getDate(), k -> new java.util.ArrayList<>()).add(s);
        }

        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);

        int firstDayOfWeekOffset = firstDay.getDayOfWeek().getValue() % 7;

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("year", targetYear);
        model.addAttribute("month", targetMonth);
        model.addAttribute("firstDay", firstDay);
        model.addAttribute("lastDay", lastDay);
        model.addAttribute("firstDayOfWeekOffset", firstDayOfWeekOffset);
        model.addAttribute("today", today);
        model.addAttribute("monthSchedules", monthSchedules);
        model.addAttribute("todaySchedules", todaySchedules);
        model.addAttribute("scheduleMap", scheduleMap);

        // Previous/next month
        YearMonth prev = yearMonth.minusMonths(1);
        YearMonth next = yearMonth.plusMonths(1);
        model.addAttribute("prevYear", prev.getYear());
        model.addAttribute("prevMonth", prev.getMonthValue());
        model.addAttribute("nextYear", next.getYear());
        model.addAttribute("nextMonth", next.getMonthValue());

        return "calendar";
    }

    @PostMapping("/schedule")
    public String addSchedule(
            @RequestParam("date") String date,
            @RequestParam("title") String title,
            @RequestParam(name = "detail", required = false) String detail,
            @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElseThrow();
        LocalDate localDate = LocalDate.parse(date);
        scheduleService.save(localDate, title, detail, currentUser.getId());
        return "redirect:/calendar";
    }
}
