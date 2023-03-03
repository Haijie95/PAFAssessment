package com.haijie.PAFAssessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haijie.PAFAssessment.repositories.AccountRepository;

import java.util.List;

import com.haijie.PAFAssessment.models.Accounts;
import com.haijie.PAFAssessment.models.TransferDetails;

@Service
public class AcccountService {
    
    @Autowired
    AccountRepository arepo;

    public List<Accounts> getAllAccount(){
        return arepo.getAllAccount();
    }

    public String validateTransfer(TransferDetails xferdet){

        
        Accounts toAcc = arepo.findByName(xferdet.getToAccId());
        Accounts fromAcc = arepo.findByName(xferdet.getFromAccId());

        
        //C0
        if(toAcc==null || fromAcc==null){
            return "Account does not exist!";
        } //C1
        else if(toAcc.getAccountId().length()!=10 || fromAcc.getAccountId().length()!=10){
            return "Account id length is not 10 chracters.";
        } //C2
        else if(toAcc.getAccountId()==fromAcc.getAccountId()){
            return "Cannot transfer to the same account.";
        } //C3
        else if(xferdet.getAmount()<=0){
            return "Transfer amount cannot be $0 or negative!";
        } //C4
        else if(xferdet.getAmount()<10){
            return "Transfer amount cannot be less than $10!";
        } //C5
        else if(fromAcc.getBalance()<xferdet.getAmount()){
            return "Account does not have sufficient amount to transfer!";
        }
        return "";
    }

}
