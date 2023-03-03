package com.haijie.PAFAssessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.haijie.PAFAssessment.exception.AccountException;
import com.haijie.PAFAssessment.models.Accounts;
import com.haijie.PAFAssessment.models.Log;
import com.haijie.PAFAssessment.models.TransferDetails;
import com.haijie.PAFAssessment.services.AcccountService;
import com.haijie.PAFAssessment.services.FundsTransferService;


@Controller
public class FundsTransferController {
    
    @Autowired
    AcccountService asvc;

    @Autowired
    FundsTransferService fts;

    @GetMapping(path={"/", "/index.html"})
    public String test(Model model){
        List<Accounts> account = asvc.getAllAccount();

        model.addAttribute("account", account);
        model.addAttribute("xferdet", new TransferDetails());

        System.out.println(account);
        

        return "index";
    }

    @PostMapping(path="/transfer",consumes = "application/x-www-form-urlencoded")
	public String postPizza(TransferDetails xferdet,Model model) throws AccountException {

        System.out.println(xferdet);
        System.out.println(xferdet.getToAccId());
        System.out.println(xferdet.getFromAccId());

        String error="";
        error = asvc.validateTransfer(xferdet);

        if(error.length()==0){
            Log log = fts.transfer(xferdet);
            System.out.println(log);
            model.addAttribute("log", log);
            return "success";
        } else{
            System.out.println(xferdet.getError());
            List<Accounts> account = asvc.getAllAccount();
            model.addAttribute("account", account);
            xferdet.setError(error);
            model.addAttribute("xferdet", xferdet);
            return "index";
        }
        
        
	}
}
