package com.example.jpamanytomany.Controller;

import com.example.jpamanytomany.Model.Subject;
import com.example.jpamanytomany.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/Subjects")
    public List<Subject> getSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjects = subjectRepository.findAll();
        return subjects;

    }

    @PostMapping("/Subjects")
    public Subject createStudent(Subject subject){
       return subjectRepository.save(subject);

    }
}
