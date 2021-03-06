package com.tt.teachers.service.impl;

import com.tt.teachers.dao.ResultDao;
import com.tt.teachers.pojo.Result;
import com.tt.teachers.pojo.Subject;
import com.tt.teachers.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{
    @Resource
    private ResultDao resultDao;

    public List<Result> getResult() {
        return resultDao.getResult();
    }

    @Transactional
    public int updateResult(Result result) {
        return resultDao.updateResult(result);
    }

    @Transactional
    public int deleteResult(Integer resultNo) {
        return resultDao.deleteResult(resultNo);
    }

    @Transactional
    public int addResult(Result result) {
        return resultDao.addResult(result);
    }

    public List<Subject> getSubject() {
        return resultDao.getSubject();
    }
}
