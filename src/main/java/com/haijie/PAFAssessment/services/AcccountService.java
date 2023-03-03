package com.haijie.PAFAssessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haijie.PAFAssessment.repositories.AccountRepository;

import java.util.List;

import com.haijie.PAFAssessment.models.Accounts;

@Service
public class AcccountService {
    
    @Autowired
    AccountRepository arepo;

    public List<Accounts> getAllAccount(){
        return arepo.getAllAccount();
    }

}
