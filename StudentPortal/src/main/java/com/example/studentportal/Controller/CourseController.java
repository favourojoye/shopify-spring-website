package com.example.studentportal.Controller;

import com.example.studentportal.model.Course;
import com.example.studentportal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courseList"; // This corresponds to the Thymeleaf template name for displaying course list
    }

    @GetMapping("/{id}")
    public String getCourseById(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + id));
        model.addAttribute("course", course);
        return "courseDetails"; // Thymeleaf template name for displaying course details
    }

    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse"; // Thymeleaf template name for adding a new course
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses"; // Redirect to the list of courses after adding
    }

    @GetMapping("/{id}/edit")
    public String showEditCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + id));
        model.addAttribute("course", course);
        return "editCourse"; // Thymeleaf template name for editing course details
    }

    @PostMapping("/{id}/edit")
    public String editCourse(@PathVariable Long id, @ModelAttribute Course course) {
        course.setId(id); // Set the ID to ensure correct update
        courseService.saveCourse(course);
        return "redirect:/courses"; // Redirect to the list of courses after editing
    }

    @GetMapping("/{id}/delete")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses"; // Redirect to the list of courses after deleting
    }
}
