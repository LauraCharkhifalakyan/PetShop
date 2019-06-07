package com.example.admin.controller;

import am.gitc.backend.common.model.AdminUser;
import am.gitc.backend.common.repository.AdminUserRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class RegisterController {

    @Autowired
    private AdminUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${image.upload.dir}")
    private String imageUploadDir;

    @GetMapping("/register")
    public String registerView() {
        return "register";
    }

    @PostMapping("/register")
    public String userRegister(@ModelAttribute AdminUser user, @RequestParam("pic") MultipartFile file) throws IOException {
       userHelper(user, file);
        return "login";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute AdminUser user, @RequestParam("picture") MultipartFile file) throws IOException {
        userHelper(user, file);
        return "addUser";
    }

    private void userHelper(AdminUser adminuser, MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\user_files\\" + fileName);
        file.transferTo(picture);
        adminuser.setAvatar(fileName);
        adminuser.setPassword(passwordEncoder.encode(adminuser.getPassword()));
        userRepository.save(adminuser);
    }

    @GetMapping("/user/getImage")
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("picUrl") String picUrl) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\user_files\\" + picUrl);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
