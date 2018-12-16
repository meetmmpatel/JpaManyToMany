package com.example.jpamanytomany;

import com.example.jpamanytomany.Model.Student;
import com.example.jpamanytomany.Model.Subject;
import com.example.jpamanytomany.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpamanytomanyApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpamanytomanyApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // delete all tables
        studentRepository.deleteAll();

        Student jack = new Student("Jack");
        Student peter = new Student("Peter");

        Subject math = new Subject("Mathematics");
        Subject computer = new Subject("Compter");

        Set<Subject> subjects = new HashSet<Subject>();
        subjects.add(math);
        subjects.add(computer);

        jack.setSubjects(subjects);
        peter.setSubjects(subjects);

        studentRepository.save(jack);
        studentRepository.save(peter);


    }
}

