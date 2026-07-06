package com.khushal.crudspringbootdemo.repository;

import com.khushal.crudspringbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {



    Optional<Student> findByIdAndIsDeletedIsFalse(Long aLong);

    List<Student> findByIsDeletedIsFalse();
// Syntax Rules :
//    findBy + fieldName + condition -> findByIdAndIsDeletedIsFalse
//    findAll ke sath "And" use nhi hota hai -> findAllAndIsDeletedIsFalse
}
