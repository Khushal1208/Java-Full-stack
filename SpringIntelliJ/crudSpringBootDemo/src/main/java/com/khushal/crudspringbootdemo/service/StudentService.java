package com.khushal.crudspringbootdemo.service;

import com.khushal.crudspringbootdemo.entity.Student;
import com.khushal.crudspringbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()) return studentResp.get();
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentResp = studentRepository.findAll();
        return studentResp;
    }

    public Student updateStudent(Long id , Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()) return null;

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;

        studentRepository.deleteById(id);
        return true;
    }
}
