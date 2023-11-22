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
        student.setName("virat kohli");
        student.setAge(35);
        student.setSalary(500000.0);

        // Save student
        Student savedStudent = studentService.saveStudent(student);
        assertNotNull(savedStudent.getId());

        // Retrieve student by ID
        Student retrievedStudent = studentService.getStudentById(savedStudent.getId());
        assertEquals("virat kohli", retrievedStudent.getName());
        assertEquals(35, retrievedStudent.getAge());
        assertEquals(500000.0, retrievedStudent.getSalary());

        // Clean up
        studentService.deleteStudent(savedStudent.getId());
    }
}

