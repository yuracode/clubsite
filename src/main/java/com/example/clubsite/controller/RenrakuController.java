package com.example.clubsite.controller;

import com.example.clubsite.mapper.UserMapper;
import com.example.clubsite.model.User;
import com.example.clubsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class RenrakuController {

    private final PostService postService;
    private final UserMapper userMapper;

    @GetMapping("/renraku")
    public String renrakuPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElse(null);
        model.addAttribute("currentUser", currentUser);
        return "renraku";
    }

    @PostMapping("/renraku")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("category") String category,
            @RequestParam(name = "image", required = false) MultipartFile image,
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {
        try {
            User currentUser = userMapper.findByNickname(userDetails.getUsername()).orElseThrow();
            postService.createPost(title, content, category, currentUser.getId(), image);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "投稿中にエラーが発生しました。");
            return "renraku";
        }
    }
}
