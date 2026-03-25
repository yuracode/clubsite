package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.User;
import com.example.clubsite.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostLikeController {

    private final PostLikeService postLikeService;
    private final UserMapper userMapper;

    @PostMapping("/post-likes/toggle")
    public String toggle(
            @RequestParam("postId") Long postId,
            @RequestParam(name = "redirectTo", defaultValue = "/home") String redirectTo,
            @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElseThrow();
        postLikeService.toggle(currentUser.getId(), postId);
        return "redirect:" + redirectTo;
    }
}
