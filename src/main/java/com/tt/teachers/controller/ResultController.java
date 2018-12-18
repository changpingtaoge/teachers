package com.tt.teachers.controller;

import com.tt.teachers.pojo.Result;
import com.tt.teachers.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    @RequestMapping("/result")
    public String result() {
        return "/result/result";
    }

    @RequestMapping(value = "/getResult",method = RequestMethod.GET)
    public @ResponseBody Object getResult() {
        List<Result> list = resultService.getResult();
        return list;
    }

    @RequestMapping(value = "/updateResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateResult(@RequestParam Integer resultNo,@RequestParam Integer studentResult) {
        Result result = new Result();
        result.setResultNo(resultNo);
        result.setStudentResult(studentResult);
        int result2 = resultService.updateResult(result);
        if (result2>0){
            return "修改成功！";
        }
        return "修改失败!";
    }
}
