package com.khushal.crudspringbootdemo.controller;

import com.khushal.crudspringbootdemo.entity.Student;
import com.khushal.crudspringbootdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
//      return ResponseEntity.status(201).body(createdStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp =  studentService.getStudent(id);
        if(studentResp == null) return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList =  studentService.getAllStudents();
        if(studentList.isEmpty()) return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentReq) {
        Student studentResp =  studentService.updateStudent(id,studentReq);
        if(studentResp == null) return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted =  studentService.deleteStudent(id);
        if(!isDeleted) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record deleted");
    }

}
