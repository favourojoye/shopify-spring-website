package com.example.studentportal.Controller;

import com.example.studentportal.model.Admin;
import com.example.studentportal.model.Course;
import com.example.studentportal.model.Student;
import com.example.studentportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/students")
    public String viewStudentList(Model model) {

        return "studentList"; // Thymeleaf template name for displaying student list
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student) {

        return "redirect:/admin/students";
    }

    @GetMapping("/students/{id}/edit")
    public String showEditStudentForm(@PathVariable Long id, Model model) {

        return "editStudent";
    }

    @PostMapping("/students/{id}/edit")
    public String editStudent(@PathVariable Long id, @ModelAttribute Student student) {

        return "redirect:/admin/students"; }

    @GetMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {

        return "redirect:/admin/students";
    }

    @GetMapping("/courses")
    public String viewCourseList(Model model) {

        return "courseList";
    }

    @GetMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse"; // Thymeleaf template name for adding a new course
    }

    @PostMapping("/courses/add")
    public String addCourse(@ModelAttribute Course course) {
        // Implement logic to add a new course
        return "redirect:/admin/courses"; // Redirect to the course list after adding
    }

    @GetMapping("/courses/{id}/edit")
    public String showEditCourseForm(@PathVariable Long id, Model model) {
        // Implement logic to retrieve and display the form for editing a course
        return "editCourse"; // Thymeleaf template name for editing course details
    }

    @PostMapping("/courses/{id}/edit")
    public String editCourse(@PathVariable Long id, @ModelAttribute Course course) {
        // Implement logic to edit an existing course
        return "redirect:/admin/courses"; // Redirect to the course list after editing
    }

    @GetMapping("/courses/{id}/delete")
    public String deleteCourse(@PathVariable Long id) {
        // Implement logic to delete an existing course
        return "redirect:/admin/courses"; // Redirect to the course list after deleting
    }
}
