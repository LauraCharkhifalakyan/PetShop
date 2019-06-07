package com.example.admin.controller;

import am.gitc.backend.common.model.AdminFeed;
import am.gitc.backend.common.repository.AdminFeedRepository;
import am.gitc.backend.common.repository.ForDogFeedRepository;
import am.gitc.backend.common.repository.ForKatFeedRepository;
import am.gitc.backend.common.repository.OtherFeedRepository;
import com.example.admin.security.SpringUser;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import java.util.Date;

@Controller
public class FeedController {

    @Autowired
    private AdminFeedRepository feedRepository;

    @Autowired
    private ForDogFeedRepository forDogFeedRepository;

    @Autowired
    private ForKatFeedRepository forKatFeedRepository;

    @Autowired
    private OtherFeedRepository otherFeedRepository;


    @PostMapping("/addFeed")
    public String addFeed(@ModelAttribute AdminFeed feed, @RequestParam("picture") MultipartFile file,
                          @AuthenticationPrincipal SpringUser springUser) throws IOException {
        addFeedHelper(feed, file, springUser);
        return "redirect:/addFeedPage";
    }

    @PostMapping("/user/addFeed")
    public String userAddFeed(@ModelAttribute AdminFeed feed, @RequestParam("picture") MultipartFile file,
                              @AuthenticationPrincipal SpringUser springUser) throws IOException {
        addFeedHelper(feed, file, springUser);
        return "redirect:/user/addFeedPage";
    }

//    private void addFeedHelper(AdminFeed feed, SpringUser springUser, MultipartFile[] files) throws IOException {
//        AdminFeed savedFeed = feedRepository.save(feed);
//        for (MultipartFile multipartFile : files) {
//            AdminFeedImage feedImage = new AdminFeedImage();
//            String name = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
//            File file = new File("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\feed_files\\" + name);
//            multipartFile.transferTo(file);
//            feedImage.setPath(name);
//            feed.setUser(springUser.getUser());
//            feed.setCreatedDate(new Date());
//            feedImage.setFeed(savedFeed);
//            feedImageRepository.save(feedImage);
//        }
//    }

    private void addFeedHelper(AdminFeed feed, MultipartFile file, SpringUser springUser) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\feed_files\\" + fileName);
        file.transferTo(picture);
        feed.setImage(fileName);
        feed.setCreatedDate(new Date());
        feed.setUser(springUser.getUser());
        feedRepository.save(feed);
    }

    @GetMapping("/feed/getImage")
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("imageUrl") String imageUrl) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\feed_files\\" + imageUrl);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


    @GetMapping("/addFeedPage")
    public String addFeedPage(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("forKatFeeds", forKatFeedRepository.findAll());
        map.addAttribute("forDogFeeds", forDogFeedRepository.findAll());
        map.addAttribute("otherFeeds", otherFeedRepository.findAll());
        map.addAttribute("user", springUser.getUser());
        return "addFeed";
    }

    @GetMapping("/user/addFeedPage")
    public String userAddFeedPage(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("forKatFeeds", forKatFeedRepository.findAll());
        map.addAttribute("otherFeeds", otherFeedRepository.findAll());
        map.addAttribute("forDogFeeds", forDogFeedRepository.findAll());
        map.addAttribute("user", springUser.getUser());
        return "userAddFeed";
    }

    @GetMapping("/allFeeds")
    public String allFeeds(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("user", springUser.getUser());
        map.addAttribute("feeds", feedRepository.findAll());
        return "allFeeds";
    }

    @GetMapping("/feed/delete")
    public String deleteFeed(int id) {
        feedRepository.deleteById(id);
        return "redirect:/allFeeds";
    }

    @GetMapping("/user/allFeeds")
    public String userAllFeeds(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("user", springUser.getUser());
        map.addAttribute("feeds", feedRepository.findAllByUserId(springUser.getUser().getId()));
        return "userAllFeeds";
    }

    @GetMapping("/user/feed/delete")
    public String userDeleteFeed(int id) {
        feedRepository.deleteById(id);
        return "redirect:/user/allFeeds";
    }
}
