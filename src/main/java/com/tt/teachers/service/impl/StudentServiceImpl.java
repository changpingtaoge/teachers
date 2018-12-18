package com.tt.teachers.service.impl;

import com.tt.teachers.dao.StudentDao;
import com.tt.teachers.pojo.Student;
import com.tt.teachers.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentDao studentDao;

    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    public List<Student> studentList() {
        return studentDao.studentList();
    }

    @Transactional
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Transactional
    public int deleteStudent(Integer studentNo) {
        return studentDao.deleteStudent(studentNo);
    }

    public Student findStuByNo(Integer studentNo) {
        return studentDao.findStuByNo(studentNo);
    }
}
