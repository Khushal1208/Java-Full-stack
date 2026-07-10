package com.khushal.crudspringbootdemo.service;

import com.khushal.crudspringbootdemo.DTO.CreateStudentRequestDTO;
import com.khushal.crudspringbootdemo.DTO.CreateStudentResponseDTO;
import com.khushal.crudspringbootdemo.DTO.UpdateStudentRequestDTO;
import com.khushal.crudspringbootdemo.DTO.UpdateStudentResponseDTO;
import com.khushal.crudspringbootdemo.entity.Student;
import com.khushal.crudspringbootdemo.exception.DuplicateResourceException;
import com.khushal.crudspringbootdemo.exception.ResourceNotFoundException;
import com.khushal.crudspringbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReqDto) {
        Student student = mapToEntity(studentReqDto);

        if(emailExists(student)){
            throw  new DuplicateResourceException("Email already exists");
        }

        Student studentRes =  studentRepository.save(student);

        return mapToDto(studentRes);
    }

    public CreateStudentResponseDTO getStudent(Long id) {
        Student studentResp =  studentRepository
                .findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found!"));

        return mapToDto(studentResp);
    }

    public List<CreateStudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findByIsDeletedIsFalse();

        return studentList
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateStudentResponseDTO updateStudent(Long id , UpdateStudentRequestDTO updateStudentRequestDTO) {
        Student existingStudent = studentRepository
                .findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Student with id " + id + " not found!"));

        existingStudent.setName(updateStudentRequestDTO.getName());
        existingStudent.setRollNo(updateStudentRequestDTO.getRollNo());
        existingStudent.setSubject(updateStudentRequestDTO.getSubject());
        existingStudent.setAge(updateStudentRequestDTO.getAge());
        existingStudent.setIsDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);
        return mapToUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Student with id " + id + " not found!"));

        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id) {

        Student studentToBeDeleted = studentRepository.findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Student with id " + id + " not found!"));

        studentToBeDeleted.setIsDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDTO studentReqDto) {
        Student student = new Student();
        student.setName(studentReqDto.getName());
        student.setRollNo(studentReqDto.getRollNo());
        student.setSubject(studentReqDto.getSubject());
        student.setEmail(studentReqDto.getEmail());
        student.setAge(studentReqDto.getAge());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setIsDeleted(false);
        return student;
    }

    private CreateStudentResponseDTO mapToDto(Student student) {
        CreateStudentResponseDTO studentResDto = new CreateStudentResponseDTO();

        studentResDto.setId(student.getId());
        studentResDto.setName(student.getName());
        studentResDto.setRollNo(student.getRollNo());
        studentResDto.setSubject(student.getSubject());
        studentResDto.setEmail(student.getEmail());
        studentResDto.setAge(student.getAge());

        studentResDto.setMessage("Student saved Successfully");
        studentResDto.setCreatedAt(student.getCreatedAt());
        studentResDto.setUpdatedAt(student.getUpdatedAt());

        return studentResDto;
    }


    private UpdateStudentResponseDTO mapToUpdateDto(Student student) {
        UpdateStudentResponseDTO studentResDto = new UpdateStudentResponseDTO();
        studentResDto.setId(student.getId());
        studentResDto.setName(student.getName());
        studentResDto.setRollNo(student.getRollNo());
        studentResDto.setSubject(student.getSubject());
        studentResDto.setEmail(student.getEmail());
        studentResDto.setAge(student.getAge());

        studentResDto.setMessage("Student Updated Successfully");
        studentResDto.setUpdatedAt(student.getUpdatedAt());

        return studentResDto;
    }


    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }


}
