package com.haijie.PAFAssessment.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetails implements Serializable {
    
    private String toName;
    private String fromName;
    private float amount;
    private String comments;
    private String error;
    
}
