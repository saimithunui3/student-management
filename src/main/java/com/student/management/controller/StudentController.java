package com.student.management.controller;

import com.student.management.model.Student;
import com.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Landing page at /home
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    // Redirect root URL to /home
    @GetMapping("/")
    public String viewRoot() {
        return "redirect:/home";
    }

    // Show form to add new student
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new_student";
    }

    // Save student to DB
    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return (student.getId() == null) ? "new_student" : "update_student";
        }
        studentService.saveStudent(student);
        return "redirect:/page/1";
    }

    // Show form to update student
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    // Delete student
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/page/1";
    }

    // List with pagination
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Student> page = studentService.findPaginated(pageNo, pageSize);
        List<Student> listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listStudents", listStudents);

        return "index";
    }

    // Search students
    @GetMapping("/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<Student> results = studentService.searchStudents(keyword);
        model.addAttribute("listStudents", results);
        return "index";
    }
}
