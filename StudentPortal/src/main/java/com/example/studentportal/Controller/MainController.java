package com.example.studentportal.Controller;

import com.example.studentportal.model.Admin;
import com.example.studentportal.model.Course;
import com.example.studentportal.model.Student;
import com.example.studentportal.service.AdminService;
import com.example.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final StudentService studentService;
    private final AdminService adminService;

    @Autowired
    public MainController(StudentService studentService, AdminService adminService) {
        this.studentService = studentService;
        this.adminService = adminService;
    }

    // Mapping for the student login page
    @GetMapping("/student/login")
    public String showStudentLoginPage() {
        return "StudentLogin";
    }

    // Mapping for the admin login page
    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "AdminLogin";
    }

    // Mapping for the student dashboard after login
    @GetMapping("/student/dashboard")
    public String showStudentDashboard() {
        // Add logic to display student dashboard
        return "index"; // Redirect to index page for now
    }

    // Mapping for the admin dashboard after login
    @GetMapping("/admin/dashboard")
    public String showAdminDashboard() {
        // Add logic to display admin dashboard
        return "index"; // Redirect to index page for now
    }

    // Mapping for student registration form
    @GetMapping("/student/register")
    public String showStudentRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    // Mapping for admin registration form
    @GetMapping("/admin/register")
    public String showAdminRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "addAdmin";
    }

    // Mapping to handle student registration form submission
    @PostMapping("/student/register")
    public String registerStudent(@ModelAttribute Student student) {
        // Add logic to register student
        return "register_success"; // Redirect to success page
    }

    // Mapping to handle admin registration form submission
    @PostMapping("/admin/register")
    public String registerAdmin(@ModelAttribute Admin admin) {
        // Add logic to register admin
        return "register_success"; // Redirect to success page
    }

    // Add more mappings for other functionalities as needed
}
