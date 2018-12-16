package com.example.jpamanytomany.Controller;

import com.example.jpamanytomany.Model.Student;
import com.example.jpamanytomany.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/Students")
    public List<Student> getStudent(){
        List<Student> students = new ArrayList<>();
        students = studentRepository.findAll();
        return  students;
    }

    @PostMapping("/Students")
    public Student createStudent(Student student){
        return  studentRepository.save(student);

    }
}
