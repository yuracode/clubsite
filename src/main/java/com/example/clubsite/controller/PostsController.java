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
public class PostsController {

    private final PostService postService;
    private final UserMapper userMapper;
    private final PostLikeService postLikeService;

    @GetMapping("/posts")
    public String postsPage(
            @RequestParam("userId") Long userId,
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {
        List<Post> posts = postService.findByAuthorId(userId);
        User author = userMapper.findById(userId).orElse(null);
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);
        model.addAttribute("posts", posts);
        model.addAttribute("author", author);
        model.addAttribute("currentUser", currentUser);
        if (currentUser != null) {
            model.addAttribute("likedPostIds", postLikeService.getLikedPostIds(currentUser.getId()));
        } else {
            model.addAttribute("likedPostIds", new HashSet<>());
        }
        return "posts";
    }
}
