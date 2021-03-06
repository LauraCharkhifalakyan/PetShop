package com.example.admin.controller;

import am.gitc.backend.common.model.AdminUserType;
import com.example.admin.security.SpringUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal SpringUser springUser) {
        if (springUser.getUser().getUserType() == AdminUserType.ADMIN) {
            return "redirect:/admin";
        }
        return "redirect:/user";
    }

}
