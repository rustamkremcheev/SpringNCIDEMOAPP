package com.example.demo.controller;

import com.example.demo.component.DBComponent;
import com.example.demo.model.Employee;
import com.example.demo.model.Employee2;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RestQuery {


   /* @GetMapping("/getQuery")
    public String getResp() {
        return "This is SpringApp!";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createEmp")
    public Employee createEmployee(@RequestBody Employee employee) {

        return employee;
    }*/

    @RequestMapping(value = "/rustam", method = RequestMethod.GET)
    public ModelAndView firstThymeleafLesson(Model m) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rustam");
        m.addAttribute("rustam", new Employee());
        return modelAndView;
    }

    @RequestMapping(value = "/rustam", method = RequestMethod.POST)
    public ModelAndView greetingSubmit(@ModelAttribute Employee employee, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rustam");
        model.addAttribute("employee", employee);
        System.out.println(model.toString());
        return modelAndView;
    }

    /*@PostMapping("/accept")
    public void emp(@RequestBody Employee employee) {
        System.out.println(employee.getFio());
        System.out.println(employee.getBirth_date());
    }*/

    @Autowired
    DBComponent db = new DBComponent();

    @RequestMapping("/sql")
    public String sqlQuery() {
        return "Q";
    }


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/acc")
    public ResponseEntity<List<Employee2>> getEmp() {
        List<Employee2> employee2s = employeeService.findAll();
        return new ResponseEntity<List<Employee2>>(employee2s, HttpStatus.OK);
    }

    @PostMapping("/acc")
    public ResponseEntity<Void> setEmp(@RequestBody Employee2 employee2) {
        boolean flag = employeeService.save(employee2);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
