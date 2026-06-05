package com.example.security.controller;

import com.example.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    static List<Student> students = new ArrayList<>();
    static{
        students.add(new Student(1,"Tony","Java"));
        students.add(new Student(2,"James","Java"));
        students.add(new Student(3,"James","Java"));
    }
    @GetMapping
    public List<Student> getStudents(){
        return students;
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return students.get(id);
    }
    @PostMapping
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "success";
    }
    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
