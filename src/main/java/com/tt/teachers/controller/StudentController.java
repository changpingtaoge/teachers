package com.tt.teachers.controller;

import com.tt.teachers.pojo.Student;
import com.tt.teachers.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/login")
    public String login() {
        return "/student/login";
    }

    @RequestMapping("/student")
    public String student() {
        return "/student/student";
    }

    @RequestMapping("/index")
    public String index(HttpSession session) {
        String studentName = (String) session.getAttribute("studentName");
        if (studentName==null){
            return "/student/login";
        }
        return "/student/index";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpSession session) {
        String xuehao = request.getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = request.getParameter("loginPwd");
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1 = studentService.doLogin(student);
        if (student1!=null){
            session.setAttribute("studentName",student1.getStudentName());
            return "forward:/stu/index";
        }
        return "redirect:/stu/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("studentName");
        return "redirect:/stu/login";
    }

    @RequestMapping("/studentList")
    @ResponseBody
    public Object studentList() {
        List<Student> list = studentService.studentList();
        return list;
    }

    @RequestMapping(value = "/updateStu",method = RequestMethod.POST)
    public String updateStu(HttpServletRequest request) {
        String stuNo = request.getParameter("stuNo");
        Integer studentNo = Integer.parseInt(stuNo);
        String stuName = request.getParameter("stuName");
        String stuPwd = request.getParameter("stuPwd");
        String stuPhone =  request.getParameter("stuPhone");
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(stuPwd);
        student.setStudentName(stuName);
        student.setPhone(stuPhone);
        int result = studentService.updateStudent(student);
        if (result>0){
            return "/student/student";
        }
        return "/student/student";
    }

    @RequestMapping(value = "/deleteStudent/{studentNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStudent(@PathVariable Integer studentNo) {
        int result = studentService.deleteStudent(studentNo);
        if (result>0){
            return "删除成功";
        }
        return "删除失败";
    }
}
