package com.khushal.Controller;

import com.khushal.entity.Student;
import com.khushal.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentRes = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Student studentRes = studentService.getStudent(id);

        if(studentRes == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentsRes = studentService.getAllStudent();

        return ResponseEntity.ok(studentsRes);
    }
}
