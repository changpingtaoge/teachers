package com.tt.teachers.dao;

import com.tt.teachers.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {

    @Select("select * from student where studentNo = #{studentNo} and loginPwd = #{loginPwd}")
    Student doLogin(Student student);

    @Select("select student.*,grade.gradeName as gradeName from student,grade where student.gradeId = grade.gradeID")
    List<Student> studentList();

    @Update("update student set studentName = #{studentName},loginPwd = #{loginPwd},phone = #{phone} where studentNo = #{studentNo}")
    int updateStudent(Student student);

    @Delete("delete from student where studentNo = #{studentNo}")
    int deleteStudent(Integer studentNo);

    @Select("select * from student where studentNo = #{studentNo}")
    Student findStuByNo(Integer studentNo);
}
