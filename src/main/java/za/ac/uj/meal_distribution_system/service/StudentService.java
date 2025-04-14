package za.ac.uj.meal_distribution_system.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.uj.meal_distribution_system.model.Student;

@Service
public interface StudentService {
    Student findStudentByStudentNumber(String studentNumber);
    Page<Student> findAllStudents(int page, int size);
    Page<Student> searchStudents(String searchTerm, int page, int size);
    void importStudentsFromExcel(MultipartFile file);
    void approveStudent(String studentNumber);
}
