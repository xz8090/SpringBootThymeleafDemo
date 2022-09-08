package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhoujie
 * @since 2020-11-17
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public ModelAndView userList(Model model){
        model.addAttribute("studentList",getStudentList());
        model.addAttribute("title","学生管理");
        return new ModelAndView("index","studentModel",model);
    }

    @GetMapping("/form")
    public ModelAndView form(Model model){
        model.addAttribute("title","添加学生");
        model.addAttribute("user",new Student());
        return new ModelAndView("add","userModel",model);
    }

    @RequestMapping(value="/add",method= RequestMethod.POST)
    public String add(@ModelAttribute Student user,Model model){
        studentMapper.insert(user);
        return "redirect:/student";
    }

    /**
     *获取学生列表
     * @author qqg
     * @date
     * @param  * @param model
     * @return
     */
    private List<Student> getStudentList(){
        List<Student> lists = studentMapper.selectList(null);
        return lists;
    }
}

