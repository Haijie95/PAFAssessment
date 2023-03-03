package com.haijie.PAFAssessment.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.haijie.PAFAssessment.models.Accounts;
import static com.haijie.PAFAssessment.SQLStatements.*;

@Repository
public class AccountRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Accounts> getAllAccount(){
        return jdbcTemplate.query(selectAllSQL, BeanPropertyRowMapper
        .newInstance(Accounts.class));
    }

    public Accounts findByName(String accId){
        return jdbcTemplate.queryForObject(findByAccIdSQL,BeanPropertyRowMapper
        .newInstance(Accounts.class),accId);
    }

    public Boolean withdraw(Accounts acc, Float amount){
        Integer result = jdbcTemplate.update(withdrawByAccId,amount,acc.getAccountId());
        return result > 0?true:false;
    }

    public Boolean deposit(Accounts acc, Float amount){
        Integer result = jdbcTemplate.update(depositByAccId,amount,acc.getAccountId());
        return result > 0?true:false;
    }


}
