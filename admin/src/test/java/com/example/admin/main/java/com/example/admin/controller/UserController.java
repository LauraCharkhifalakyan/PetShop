package com.example.admin.controller;

import am.gitc.backend.common.repository.AdminUserRepository;
import com.example.admin.security.SpringUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userPage() {
        return "redirect:/user/addAnimalPage";
    }

    @Autowired
    private AdminUserRepository userRepository;

    @GetMapping("/addUserPage")
    public String addUserPage(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("user", springUser.getUser());
        return "addUser";
    }

    @GetMapping("/allUsers")
    public String allUsers(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("users", userRepository.findAll());
        map.addAttribute("user", springUser.getUser());
        return "allUsers";
    }

    @GetMapping("/delete")
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "redirect:/allUsers";
    }
}
