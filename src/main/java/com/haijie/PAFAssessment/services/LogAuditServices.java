package com.haijie.PAFAssessment.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.haijie.PAFAssessment.models.Accounts;
import com.haijie.PAFAssessment.models.Log;
import com.haijie.PAFAssessment.models.TransferDetails;

@Service
public class LogAuditServices {
    
    // @Autowired @Qualifier("transfer")
    // private RedisTemplate<String,String> redisTemplate;

    public Log prepareLog(TransferDetails xferdet, Accounts toAcc, Accounts fromAcc,String transactionId){
         //prepare log 
         Log log = new Log();
         log.setTransactionId(transactionId);
         log.setFromAccount(fromAcc.getAccountId());
         log.setToAccount(toAcc.getAccountId());
         log.setToName(toAcc.getName());
         log.setFromName(fromAcc.getName());
         log.setDate(LocalDate.now());
         log.setAmount(xferdet.getAmount());

        //  redisTemplate.opsForValue().set("transactionId", transactionId);
        //  redisTemplate.opsForValue().set("date", log.getDate().toString());
        //  redisTemplate.opsForValue().set("from_account", log.getFromAccount());
        //  redisTemplate.opsForValue().set("to_account", log.getToAccount());
        //  redisTemplate.opsForValue().set("amount", log.getAmount().toString());
         
         return log;
    }
}
