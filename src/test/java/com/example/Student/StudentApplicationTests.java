package com.example.Student;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Entity.Student;
import com.example.Service.StudentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void testSaveAndGetStudent() {
        Student student = new Student(null, null, 0, 0);
        student.setName("John Doe");
        student.setAge(25);
        student.setSalary(50000.0);

        // Save student
        Student savedStudent = studentService.saveStudent(student);
        assertNotNull(savedStudent.getId());

        // Retrieve student by ID
        Student retrievedStudent = studentService.getStudentById(savedStudent.getId());
        assertEquals("John Doe", retrievedStudent.getName());
        assertEquals(25, retrievedStudent.getAge());
        assertEquals(50000.0, retrievedStudent.getSalary());

        // Clean up
        studentService.deleteStudent(savedStudent.getId());
    }
}

