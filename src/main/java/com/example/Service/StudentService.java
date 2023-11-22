package com.example.Service;

import java.util.List;

import com.example.Entity.Student;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(String id);

    Student saveStudent(Student student);

    void deleteStudent(String id);
}
