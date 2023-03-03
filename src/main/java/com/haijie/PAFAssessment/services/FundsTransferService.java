package com.haijie.PAFAssessment.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haijie.PAFAssessment.exception.AccountException;
import com.haijie.PAFAssessment.models.Accounts;
import com.haijie.PAFAssessment.models.Log;
import com.haijie.PAFAssessment.models.TransferDetails;
import com.haijie.PAFAssessment.repositories.AccountRepository;

@Service
public class FundsTransferService {
    
    @Autowired
    AccountRepository arepo;

    @Autowired
    LogAuditServices las;

    @Transactional(rollbackFor = AccountException.class)
    public Log transfer(TransferDetails xferdet) throws AccountException{

        String transactionId= UUID.randomUUID().toString()
            .substring(0, 8);

        Accounts toAcc = arepo.findByName(xferdet.getToAccId());
        Accounts fromAcc = arepo.findByName(xferdet.getFromAccId());

        if(fromAcc.getBalance()==0){
            throw new AccountException();
        }

        //to transfer funds
        arepo.withdraw(fromAcc,xferdet.getAmount());
        arepo.deposit(toAcc,xferdet.getAmount());

        return las.prepareLog(xferdet, toAcc, fromAcc,transactionId); 
    }
    
}
