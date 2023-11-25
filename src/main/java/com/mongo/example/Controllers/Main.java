package com.mongo.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.Dao.StudentRepo;
import com.mongo.example.Entities.Student;

@RestController
@RequestMapping("/student")
public class Main {
    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/")
    public ResponseEntity<?> addstudent(@RequestBody Student stud){
        Student save = this.studentRepo.save(stud);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStudent(){
        
        return ResponseEntity.ok(this.studentRepo.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        this.studentRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Student stud){
        stud.setId(id);
        this.studentRepo.save(stud);
        return ResponseEntity.ok().build();
    }
}
