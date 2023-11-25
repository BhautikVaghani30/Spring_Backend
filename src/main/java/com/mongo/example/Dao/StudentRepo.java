package com.mongo.example.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.example.Entities.Student;

public interface StudentRepo extends MongoRepository<Student,Integer>{
    
}
