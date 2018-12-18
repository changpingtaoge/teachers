package com.tt.teachers.dao;

import com.tt.teachers.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {

    @Select("SELECT result.*,student.studentName AS studentName,subject.subjectName AS subjectName FROM result,student,subject WHERE result.subjectNo = subject.subjectNo AND student.studentNo = result.studentNo")
    List<Result> getResult();

    @Update("update result set studentResult = #{studentResult} where resultNo = #{resultNo}")
    int updateResult(Result result);
}
