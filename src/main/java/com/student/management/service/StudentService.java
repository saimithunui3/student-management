package com.student.management.service;

import com.student.management.model.Student;
import org.springframework.data.domain.Page;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
    Page<Student> findPaginated(int pageNo, int pageSize);
    List<Student> searchStudents(String keyword);

}
