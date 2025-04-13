package za.ac.uj.meal_distribution_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.uj.meal_distribution_system.model.QRCode;
import za.ac.uj.meal_distribution_system.model.Student;
import za.ac.uj.meal_distribution_system.service.QRCodeService;
import za.ac.uj.meal_distribution_system.service.StudentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/dashboard")
    public String showDashboard(Authentication authentication, Model model) {
        String studentNumber = authentication.getName();
        Student student = studentService.findStudentByStudentNumber(studentNumber);

        model.addAttribute("student", student);
        model.addAttribute("currentDate", LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));

        return "student/dashboard";
    }

    @PostMapping("/generate-qr")
    public String generateQRCode(Authentication authentication, Model model) {
        String studentNumber = authentication.getName();
        QRCode qrCode = qrCodeService.generateQRCode(studentNumber);

        // Send notification email
        // notificationService.sendQRCodeGeneratedEmail(student.getEmail(), qrCode);

        return "redirect:/student/qr-code";
    }

    @GetMapping("/qr-code")
    public String showQRCode(Authentication authentication, Model model) {
        String studentNumber = authentication.getName();
        QRCode qrCode = qrCodeService.getActiveQRCode(studentNumber);

        if (qrCode == null) {
            return "redirect:/student/dashboard";
        }

        model.addAttribute("qrCode", qrCode);
        return "student/qr-code";
    }
}
