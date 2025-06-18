package za.ac.uj.meal_distribution_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentLoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "student/student-login"; // This will return the student-student-login.html template
    }
}