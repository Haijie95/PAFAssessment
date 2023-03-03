package com.haijie.PAFAssessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.haijie.PAFAssessment.models.Accounts;
import com.haijie.PAFAssessment.models.TransferDetails;
import com.haijie.PAFAssessment.services.AcccountService;

@Controller
public class AccountController {
    
    @Autowired
    AcccountService asvc;

    @GetMapping(path={"/", "/index.html"})
    public String test(Model model){
        List<Accounts> account = asvc.getAllAccount();

        model.addAttribute("account", account);
        
        model.addAttribute("xferdet", new TransferDetails());

        System.out.println(account);
        

        return "index";
    }
}
