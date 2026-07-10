package com.khushal.crudspringbootdemo.controller;

import com.khushal.crudspringbootdemo.DTO.CreateStudentRequestDTO;
import com.khushal.crudspringbootdemo.DTO.CreateStudentResponseDTO;
import com.khushal.crudspringbootdemo.DTO.UpdateStudentRequestDTO;
import com.khushal.crudspringbootdemo.DTO.UpdateStudentResponseDTO;
import com.khushal.crudspringbootdemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO studentRequestDto) {
        CreateStudentResponseDTO createdStudent = studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id) {
        CreateStudentResponseDTO studentResp =  studentService.getStudent(id);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudents() {
        List<CreateStudentResponseDTO> studentList =  studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@RequestParam Long id,@RequestBody UpdateStudentRequestDTO updateStudentRequestDTO) {
        UpdateStudentResponseDTO studentResp =  studentService.updateStudent(id,updateStudentRequestDTO);
        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.noContent().build();
    }
}
