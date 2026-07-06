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
        studentReq.setIsDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {
//        Optional<Student> studentResp = studentRepository.findById(id);
//        if(studentResp.isPresent() && !studentResp.get().getIsDeleted()) return studentResp.get();

        Optional<Student> studentResp = studentRepository.findByIdAndIsDeletedIsFalse(id);  // Implementation will be provided by Spring JPA Itself
        if(studentResp.isPresent()) return studentResp.get();
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentResp = studentRepository.findByIsDeletedIsFalse();
        return studentResp;
    }

    public Student updateStudent(Long id , Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndIsDeletedIsFalse(id);
        if(existingStudent.isEmpty()) return null;

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setIsDeleted(studentReq.getIsDeleted());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;

        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent =
                studentRepository.findByIdAndIsDeletedIsFalse(id);

        if(existingStudent.isEmpty()) return false;

        Student studentToSave = existingStudent.get();
        studentToSave.setIsDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }
}
