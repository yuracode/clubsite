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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SeisakuController {

    private final TournamentService tournamentService;
    private final UserMapper userMapper;

    @GetMapping("/seisaku")
    public String seisakuPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);
        model.addAttribute("currentUser", currentUser);
        return "seisaku";
    }

    @PostMapping("/seisaku")
    public String createTournament(
            @RequestParam("name") String name,
            @RequestParam("year") Integer year,
            @RequestParam("month") Integer month,
            @RequestParam("firstPlace") String firstPlace,
            @RequestParam("secondPlace") String secondPlace,
            @RequestParam("thirdPlace") String thirdPlace,
            @RequestParam(name = "myRank", required = false) Integer myRank,
            @RequestParam(name = "myTeamName", required = false) String myTeamName,
            Model model) {
        try {
            Tournament tournament = new Tournament();
            tournament.setName(name);
            tournament.setYear(year);
            tournament.setMonth(month);
            tournament.setFirstPlace(firstPlace);
            tournament.setSecondPlace(secondPlace);
            tournament.setThirdPlace(thirdPlace);
            tournament.setMyRank(myRank);
            tournament.setMyTeamName(myTeamName);
            tournamentService.save(tournament);
            return "redirect:/tournament";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "登録中にエラーが発生しました。");
            return "seisaku";
        }
    }
}
