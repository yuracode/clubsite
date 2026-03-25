package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.Tournament;
import com.example.clubsite.model.User;
import com.example.clubsite.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;
    private final UserMapper userMapper;

    @GetMapping("/tournament")
    public String tournamentPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        int currentYear = LocalDate.now().getYear();
        List<Tournament> thisYear = tournamentService.findByYear(currentYear);
        List<Tournament> lastYear = tournamentService.findByYear(currentYear - 1);
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);
        model.addAttribute("thisYearTournaments", thisYear);
        model.addAttribute("lastYearTournaments", lastYear);
        model.addAttribute("currentYear", currentYear);
        model.addAttribute("currentUser", currentUser);
        return "tournament";
    }
}
