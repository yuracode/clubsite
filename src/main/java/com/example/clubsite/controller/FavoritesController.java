package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.Post;
import com.example.clubsite.model.User;
import com.example.clubsite.service.FavoriteService;
import com.example.clubsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FavoritesController {

    private final FavoriteService favoriteService;
    private final PostService postService;
    private final UserMapper userMapper;

    @GetMapping("/favorites")
    public String favoritesPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElseThrow();
        List<Post> posts = postService.findByFavoritedUsers(currentUser.getId());
        model.addAttribute("posts", posts);
        model.addAttribute("currentUser", currentUser);
        return "favorites";
    }

    @PostMapping("/favorites/toggle")
    public String toggleFavorite(
            @RequestParam("targetId") Long targetId,
            @RequestParam(name = "redirectTo", defaultValue = "/home") String redirectTo,
            @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElseThrow();
        favoriteService.toggleFavorite(currentUser.getId(), targetId);
        return "redirect:" + redirectTo;
    }
}
