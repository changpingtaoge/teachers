package com.tt.teachers.service;

import com.tt.teachers.pojo.Result;

import java.util.List;

public interface ResultService {
    List<Result> getResult();

    int updateResult(Result result);

    int deleteResult(Integer resultNo);

    int addResult(Result result);
}
