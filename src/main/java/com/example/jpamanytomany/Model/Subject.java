package com.example.jpamanytomany.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private Set<Student> students;

    public Subject(){

    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
