package com.example.admin.controller;

import am.gitc.backend.common.model.AdminAnimal;
import am.gitc.backend.common.repository.AdminAnimalRepository;
import am.gitc.backend.common.repository.AnimalCategoryRepository;
import am.gitc.backend.common.repository.AnimalImageRepository;
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
public class AnimalController {

    @Autowired
    private AdminAnimalRepository animalRepository;

    @Autowired
    private AnimalImageRepository animalImageRepository;

    @Autowired
    private AnimalCategoryRepository animalCategoryRepository;


    @PostMapping("/addAnimal")
    public String addAnimal(@ModelAttribute AdminAnimal animal, @RequestParam("picture") MultipartFile file,
                            @AuthenticationPrincipal SpringUser springUser) throws IOException {
        addAnimalHelper(animal, file, springUser);
        return "redirect:/addAnimalPage";
    }

    @PostMapping("/user/addAnimal")
    public String userAddAnimal(@ModelAttribute AdminAnimal animal, @RequestParam("picture") MultipartFile file,
                                @AuthenticationPrincipal SpringUser springUser) throws IOException {
        addAnimalHelper(animal, file, springUser);
        return "redirect:/user/addAnimalPage";
    }

    @GetMapping("/addAnimalPage")
    public String addAnimalPage(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("animalCategories", animalCategoryRepository.findAll());
        map.addAttribute("user", springUser.getUser());
        return "addAnimal";
    }

    @GetMapping("/user/addAnimalPage")
    public String userAddAnimalPage(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("animalCategories", animalCategoryRepository.findAll());
        map.addAttribute("user", springUser.getUser());
        return "userAddAnimal";
    }

    @GetMapping("/allAnimals")
    public String allAnimals(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("animals", animalRepository.findAll());
        map.addAttribute("user", springUser.getUser());
        return "allAnimals";
    }

    @GetMapping("/animal/delete")
    public String deleteAnimal(int id) {
        animalRepository.deleteById(id);
        return "redirect:/allAnimals";
    }

    @GetMapping("/user/allAnimals")
    public String userAllAnimals(ModelMap map, @AuthenticationPrincipal SpringUser springUser) {
        map.addAttribute("animals", animalRepository.findAllByUserId(springUser.getUser().getId()));
        map.addAttribute("user", springUser.getUser());
        return "userAllAnimals";
    }

    @GetMapping("/user/animal/delete")
    public String userDeleteAnimal(int id) {
        animalRepository.deleteById(id);
        return "redirect:/user/allAnimals";
    }

    @GetMapping("/animal/getImage")
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("picUrl") String imageUrl) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\animal_files\\" + imageUrl);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

//    private void addAnimalHelper(AdminAnimal animal, MultipartFile[] files, SpringUser springUser) throws IOException {
//        AdminAnimal savedAnimal = animalRepository.save(animal);
//        for (MultipartFile multipartFile : files) {
//            AdminAnimalImage animalImage = new AdminAnimalImage();
//            String name = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
//            File file = new File("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\animal_files\\" + name);
//            multipartFile.transferTo(file);
//            animalImage.setPath(name);
//            animal.setUser(springUser.getUser());
//            animal.setCreatedDate(new Date());
//            animalImage.setAnimal(savedAnimal);
//            animalImageRepository.save(animalImage);
//        }
//    }

    private void addAnimalHelper(AdminAnimal animal, MultipartFile file, SpringUser springUser) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File("C:\\Users\\User\\IdeaProjects\\petShop\\backend\\admin\\images\\animal_files\\" + fileName);
        file.transferTo(picture);
        animal.setImage(fileName);
        animal.setUser(springUser.getUser());
        animal.setCreatedDate(new Date());
        animalRepository.save(animal);
    }

}
