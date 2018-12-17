package com.tt.teachers.controller;

import com.tt.teachers.pojo.Student;
import com.tt.teachers.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/login")
    public String login() {
        return "/student/login";
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
}
