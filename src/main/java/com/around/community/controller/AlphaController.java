package com.around.community.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.around.community.service.AlphaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/alpha")
@Controller

public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find(); 
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // Getting Request Data

        System.out.println(request.getMethod());
        System.out.println(request.getServletPath()); // the path of the request
        Enumeration<String> enumeration =  request.getHeaderNames();
        // Header Headers
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement(); 
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
             
        }

        // Request Body
        System.out.println(request.getParameter("code"));

        // Return Response Data
        response.setContentType( "text/html;charset=utf-8");
        try (
            PrintWriter writer = response.getWriter();
        ) {
            writer.write("<h1>A Round<h1>");
        } catch (IOException e ) {
            e.printStackTrace();
        }
    } 

    // GET REQUEST
    // /students?current=1&limit=20
    @RequestMapping(path = "/students", method=RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name="current", required = false, defaultValue = "1") int current, 
            @RequestParam(name = "limit",  required = false, defaultValue = "1") int limit) {
        System.out.println(current);
        System.out.println(limit); 
        return "some students";
    }
    
    // /student/123
    @RequestMapping(path = "/student/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    // POST REQUEST
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println(name);
        System.out.println(age); 
        return "Saved Successfully";
    }

    // Respond HTML Data: method 1 - 默认返回html without annotating "@ResponseBody"
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Jeff");
        mav.addObject("age", 26);
        mav.setViewName("/demo/view");
        return mav;
    }

    // Respond HTML Data: method 2- 默认返回html without annotating "@ResponseBody"
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "UBC");
        model.addAttribute("age", "Vancouver, BC"); 
        return "demo/view";
    }

    // Respond JSON Data: Async data
    // Java Object and JS Object conversion via Json String
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Mike");
        emp.put("age", "29");
        emp.put("salary", "80000");

        return emp;
    }


    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Mike");
        emp.put("age", "29");
        emp.put("salary", "80000");
        list.add(emp);

        Map<String, Object> emp1 = new HashMap<>();
        emp1.put("name", "Lee");
        emp1.put("age", "29");
        emp1.put("salary", "90100");
        list.add(emp1);

        Map<String, Object> emp2 = new HashMap<>();
        emp2.put("name", "Jason");
        emp2.put("age", "29");
        emp2.put("salary", "100000");
        list.add(emp2);

        return list;
    }



}


