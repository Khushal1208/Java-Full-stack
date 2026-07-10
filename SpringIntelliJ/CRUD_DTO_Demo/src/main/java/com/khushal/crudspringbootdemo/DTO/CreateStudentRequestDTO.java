package com.khushal.crudspringbootdemo.DTO;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {
    @NotBlank(message = "Name cannot be null/Empty or Blank")
    @Size(min = 2, max = 50,message = "Student name must be within 2 to 50 char long")
    private String name;

    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Student email must be valid")
    private String email;

    @NotNull(message = "Age is Required")
    @Min(value = 18, message = "Age must be 18 or greater")
    private int age;

    @NotNull(message = "RollNo is Required")
    private Integer rollNo;

    @NotBlank(message = "Subject is Required")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
