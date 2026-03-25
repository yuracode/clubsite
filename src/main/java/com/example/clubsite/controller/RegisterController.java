package com.example.clubsite.controller;

import com.example.clubsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("nickname") String nickname,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(name = "profileImage", required = false) MultipartFile profileImage,
            Model model) {
        try {
            if (userService.findByNickname(nickname).isPresent()) {
                model.addAttribute("errorMessage", "このニックネームはすでに使用されています。");
                return "register";
            }
            userService.register(nickname, email, password, profileImage);
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "登録中にエラーが発生しました: " + e.getMessage());
            return "register";
        }
    }
}
