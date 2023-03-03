package com.haijie.PAFAssessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetails {
    private String nameOne;
    private String nameTwo;
    private String AccountOne;
    private String AccountTwo;
    private float balanceOne;
    private float balanceTwo;
    private float amount;
    private String comments;
    private String errormsg;
    
}
