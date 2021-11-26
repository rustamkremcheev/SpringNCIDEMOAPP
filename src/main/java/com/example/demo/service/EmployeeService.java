package com.example.demo.service;

import com.example.demo.model.Employee2;
import com.example.demo.repo.JDBCEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmpService {

    @Autowired
    JDBCEmpRepo jdbcEmpRepo;


    @Override
    public int count() {
        return jdbcEmpRepo.count();
    }

    @Override
    public boolean save(Employee2 employee2) {
        return jdbcEmpRepo.save(employee2);
    }

    @Override
    public boolean update(Employee2 employee2) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Employee2> findAll() {
        return jdbcEmpRepo.findAll();
    }

    @Override
    public List<Employee2> findByName() {
        return null;
    }

    @Override
    public Optional<Employee2> findById() {
        return Optional.empty();
    }

    @Override
    public String getNameById(Long id) {
        return null;
    }
}
