package za.ac.uj.meal_distribution_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import za.ac.uj.meal_distribution_system.model.QRCode;
import za.ac.uj.meal_distribution_system.model.Student;
import za.ac.uj.meal_distribution_system.service.QRCodeService;
import za.ac.uj.meal_distribution_system.service.StudentService;

@Configuration
public class AppConfig {
    @Bean
    public StudentService studentService() {
        return new StudentService() {
            @Override
            public Student findStudentByStudentNumber(String studentNumber) {
                return null;
            }

            @Override
            public Page<Student> findAllStudents(int page, int size) {
                return null;
            }

            @Override
            public Page<Student> searchStudents(String searchTerm, int page, int size) {
                return null;
            }

            @Override
            public void importStudentsFromExcel(MultipartFile file) {

            }

            @Override
            public void approveStudent(String studentNumber) {

            }
        };
    }

    @Bean
    public QRCodeService qrCodeService() {
        return new QRCodeService() {
            @Override
            public QRCode generateQRCode(String studentNumber) {
                return null;
            }

            @Override
            public QRCode getActiveQRCode(String studentNumber) {
                return null;
            }

            @Override
            public QRCode validateQRCode(String code) {
                return null;
            }
        };
    }
}
