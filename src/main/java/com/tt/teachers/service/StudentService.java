package com.tt.teachers.service;

import com.tt.teachers.pojo.Student;

import java.util.List;

public interface StudentService {
    Student doLogin(Student student);

    List<Student> studentList();
}
