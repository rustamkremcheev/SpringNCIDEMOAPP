package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class DBComponent {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void getInf(String uin) {
        String sqlQuery = "select * from tashkilot";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlQuery);
        for (Map<String, Object> row: list){
            System.out.println(row.get("branch"));
        }

       // jdbcTemplate.update("update korona_pay_transfers set  branch = 00394 where uin = ?", uin);

        String query = "select * from korona_pay_transfers";
        //jdbcTemplate.queryForObject(query, new Object[] {});

    }
}
