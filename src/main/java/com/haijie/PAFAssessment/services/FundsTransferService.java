package com.haijie.PAFAssessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.haijie.PAFAssessment.models.Accounts;
import com.haijie.PAFAssessment.models.TransferDetails;
import com.haijie.PAFAssessment.repositories.AccountRepository;

@Service
public class FundsTransferService {
    
    @Autowired
    AccountRepository arepo;

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void transfer(TransferDetails xferdet){

        Accounts toAcc = arepo.findByName(xferdet.getToAccId());
        Accounts fromAcc = arepo.findByName(xferdet.getFromAccId());

        if(toAcc.getBalance()==0){
            throw new IllegalArgumentException("To Account has no money!");
        }

        toAcc.setBalance(toAcc.getBalance()-xferdet.getAmount());
        
        
        
    }
    
}
