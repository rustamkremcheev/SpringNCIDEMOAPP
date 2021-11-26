package com.example.demo.service;


import com.example.demo.model.Employee2;

import java.util.List;
import java.util.Optional;

public interface EmpService {
    int count();
    boolean save(Employee2 employee2);
    boolean update(Employee2 employee2);
    boolean deleteById(Long id);
    List<Employee2> findAll();
    List<Employee2> findByName();
    Optional<Employee2> findById();
    String getNameById(Long id);

}
