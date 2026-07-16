package com.khushal.filterdemo.controller;

import com.khushal.filterdemo.dto.Student;
import com.khushal.filterdemo.dto.StudentResponseDto;
import com.khushal.filterdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService  studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody Student student){
        StudentResponseDto responseDto =  studentService.createStudent(student);
        return ResponseEntity.ok(responseDto);
    }
}
