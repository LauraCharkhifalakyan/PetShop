package com.example.admin.controller;

import am.gitc.backend.common.model.AdminAnimal;
import am.gitc.backend.common.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    @Autowired
    private AdminAnimalRepository animalRepository;

    @Autowired
    private AnimalCategoryRepository animalCategoryRepository;

    @Autowired
    private ForDogFeedRepository forDogFeedRepository;

    @Autowired
    private ForDogAccessoryRepository forDogAccessoryRepository;

    @Autowired
    private ForKatAccessoryRepository forKatAccessoryRepository;

    @Autowired
    private ForKatFeedRepository forKatFeedRepository;

    @Autowired
    private OtherFeedRepository otherFeedRepository;

    @Autowired
    private OtherAccessoryRepository otherAccessoryRepository;

    @Autowired
    private AdminFeedRepository feedRepository;

    @Autowired
    private AnimalImageRepository animalImageRepository;

    @GetMapping("/")
    public String main(ModelMap map, @ModelAttribute AdminAnimal animal){
        map.addAttribute("animalCategories", animalCategoryRepository.findAll());
        map.addAttribute("forDogFeedRepository", forDogFeedRepository.findAll());
        map.addAttribute("forDogAccessoryRepository", forDogAccessoryRepository.findAll());
        map.addAttribute("forKatAccessoryRepository", forKatAccessoryRepository.findAll());
        map.addAttribute("forKatFeedRepository", forKatFeedRepository.findAll());
        map.addAttribute("otherFeedRepository", otherFeedRepository.findAll());
        map.addAttribute("otherAccessoryRepository", otherAccessoryRepository.findAll());
        map.addAttribute("allAnimals", animalRepository.findAll());
        map.addAttribute("allFeeds", feedRepository.findAll());
        map.addAttribute("animalImage", animalImageRepository.findAll());
        return "index";
    }

    @GetMapping("/main/redirect")
    public String redirect(){
        return "redirect:/";
    }

}
