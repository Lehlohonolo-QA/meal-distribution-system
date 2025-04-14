package za.ac.uj.meal_distribution_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.uj.meal_distribution_system.model.Student;
import za.ac.uj.meal_distribution_system.service.StudentService;



@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired(required=true)
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "search", required = false) String search,
            Model model) {

        Page<Student> studentPage;
        if (search != null && !search.isEmpty()) {
            studentPage = studentService.searchStudents(search, page, size);
        } else {
            studentPage = studentService.findAllStudents(page, size);
        }

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentPage.getTotalPages());

        return "admin/students";
    }

    @PostMapping("/students/import")
    public String importStudents(@RequestParam("file") MultipartFile file) {
        studentService.importStudentsFromExcel(file);
        return "redirect:/admin/students";
    }

    @PostMapping("/students/approve/{studentNumber}")
    public String approveStudent(@PathVariable String studentNumber) {
        studentService.approveStudent(studentNumber);
        return "redirect:/admin/students";
    }
}