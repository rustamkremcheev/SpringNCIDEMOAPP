package com.example.demo.repo;

import com.example.demo.model.Employee2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JDBCEmpRepo implements EmployeeRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from tashkilot", Integer.class);
    }

    @Override
    public boolean save(Employee2 employee2) {
        try {
            jdbcTemplate.update("insert into tashkilot" +
                    "(tashkilot_id, branch, user_name)" +
                    "values(?,?,?)", employee2.getId(), employee2.getBranch(), employee2.getUser_name());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean update(Employee2 employee2) {
        try {
            jdbcTemplate.update("", employee2.getId(), employee2.getBranch(), employee2.getUser_name());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Employee2> findAll() {
        return jdbcTemplate.query("select * from tashkilot", (rs, rowNum) -> new Employee2(
                rs.getString("tashkilot_id"),
                rs.getString("branch"),
                rs.getString("user_name"),
                rs.getString("surname"),
                rs.getString("app_id"),
                rs.getString("telefon")
        ));
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
