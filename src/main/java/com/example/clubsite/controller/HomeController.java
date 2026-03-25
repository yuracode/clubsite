package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.Post;
import com.example.clubsite.model.User;
import com.example.clubsite.service.PostService;
import com.example.clubsite.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.HashSet;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;
    private final UserMapper userMapper;
    private final PostLikeService postLikeService;

    @GetMapping("/home")
    public String home(
            @RequestParam(name = "category", required = false) String category,
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {
        List<Post> posts = postService.findAll(category);
        model.addAttribute("posts", posts);
        model.addAttribute("selectedCategory", category);
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);
        model.addAttribute("currentUser", currentUser);
        if (currentUser != null) {
            model.addAttribute("likedPostIds", postLikeService.getLikedPostIds(currentUser.getId()));
        } else {
            model.addAttribute("likedPostIds", new HashSet<>());
        }
        return "home";
    }
}
