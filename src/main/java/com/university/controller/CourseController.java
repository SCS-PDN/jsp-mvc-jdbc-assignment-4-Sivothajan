package com.university.controller;

import com.university.dao.CourseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CourseController {

    private final CourseDAO courseDAO = new CourseDAO();

    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("courses", courseDAO.getAllCourses());
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String register(@PathVariable int courseId,
                           HttpSession session,
                           Model model) {

        Integer studentId = (Integer) session.getAttribute("studentId");

        if (studentId == null) {
            return "redirect:/login";
        }

        // 👇 ADD THIS CHECK HERE
        if (courseDAO.isAlreadyRegistered(studentId, courseId)) {
            model.addAttribute("message", "Already registered!");
            return "success";
        }

        // 👇 ONLY insert if not registered
        courseDAO.registerCourse(studentId, courseId);

        model.addAttribute("message", "Successfully registered!");
        return "success";
    }

    @GetMapping("/my-courses")
    public String myCourses(HttpSession session, Model model) {

        Integer studentId = (Integer) session.getAttribute("studentId");

        if (studentId == null) {
            return "redirect:/login";
        }

        model.addAttribute("courses", courseDAO.getMyCourses(studentId));
        return "my-courses";
    }
}