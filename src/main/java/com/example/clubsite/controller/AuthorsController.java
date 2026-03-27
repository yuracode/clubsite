package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.Favorite;
import com.example.clubsite.model.User;
import com.example.clubsite.service.FavoriteService;
import com.example.clubsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AuthorsController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final FavoriteService favoriteService;

    @GetMapping("/authors")
    public String authorsPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);
        model.addAttribute("currentUser", currentUser);
        if (currentUser != null) {
            Set<Long> favoritedIds = favoriteService.findByUserId(currentUser.getId())
                    .stream().map(Favorite::getTargetId).collect(Collectors.toSet());
            model.addAttribute("favoritedIds", favoritedIds);
        }
        return "authors";
    }
}
