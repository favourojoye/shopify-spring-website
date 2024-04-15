package com.spaddemplbydeptCRUD.web.controller;


import com.spaddemplbydeptCRUD.Model.Category;
import com.spaddemplbydeptCRUD.Model.Product;
import com.spaddemplbydeptCRUD.Model.User;
import com.spaddemplbydeptCRUD.Repository.UserRepository;
import com.spaddemplbydeptCRUD.Service.CategoryService;
import com.spaddemplbydeptCRUD.Service.ProductService;
import com.spaddemplbydeptCRUD.Service.ProductServiceImpl;
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
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final ProductService productService; // Inject EmployeeService
    private final CategoryService categoryService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    public MainController(ProductServiceImpl productService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String viewHomePAge(Model model) {
        return "index";
    }

    @GetMapping("/allProduct")
    public String viewProductDetails(Model model) {
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        return "ProductDetails";
    }

    @GetMapping("/productbydept")
    public String getProductByCategory(@RequestParam("categoryId") Long departmentId, Model model) {
        List<Product> products = productService.getProductsByCategory(departmentId); // Use EmployeeService
        List<Category> categories = categoryService.getAllCategory(); // Fetch departments from service
        model.addAttribute("product", products);
        model.addAttribute("categories", categories);
        // Log employee and department details
        logger.info("Product: {}", products);
        logger.info("Category: {}", model.getAttribute("category"));
        return "ProductDetails";
    }

//    @GetMapping("/employees")
//    public ModelAndView getEmployeesByDepartment(@RequestParam("departmentId") Long departmentId) {
//        ModelAndView modelAndView = new ModelAndView("employeeDetails");
//        List<Employee> employees = employeeService.getEmployeesByDepartment(departmentId);
//        List<Department> departments = departmentService.getAllDepartments(); // Fetch departments from repository
//        modelAndView.addObject("employees", employees);
//        modelAndView.addObject("departments", departments); // Add departments to the model
//        return modelAndView;
//    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "add_Product";
    }

    @PostMapping("/addProduct")
    public String addEmployee(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/allproduct";
    }

    @GetMapping("/deleteProduct/{id}")
    public String addProduct(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        productService.deleteProductById(id);
        return "redirect:/allemployees";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
        return "register_success";
    }

}