package com.example.REpo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    
}