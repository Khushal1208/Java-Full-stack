package com.khushal.filterdemo.service;

import com.khushal.filterdemo.dto.Student;
import com.khushal.filterdemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService  {

    public StudentResponseDto createStudent(Student student) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setMessage("Student is Saved Successfully");

        return responseDto;
    }

}
