package io.github.favourojoye.shopify.web.controller;


import io.github.favourojoye.shopify.model.Category;
import io.github.favourojoye.shopify.model.Product;
import io.github.favourojoye.shopify.model.User;
import io.github.favourojoye.shopify.repositories.UserRepository;
import io.github.favourojoye.shopify.services.CategoryService;
import io.github.favourojoye.shopify.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {




    @Autowired
    private UserRepository userRepo;



    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup-form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
        return "register-success";
    }

}