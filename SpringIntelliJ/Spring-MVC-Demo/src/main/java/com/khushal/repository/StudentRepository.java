package com.khushal.repository;

import com.khushal.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    private final Map<Long, Student> studentDB;

    public StudentRepository(){
        studentDB = new HashMap<>();
    }

    public Student save(Student student){
        studentDB.put(student.getId(),student);
        return student;
    }

    public Student findById(Long id){
        return studentDB.get(id);
    }

    public List<Student> findAll(){
        return new ArrayList<>(studentDB.values());
    }

}
