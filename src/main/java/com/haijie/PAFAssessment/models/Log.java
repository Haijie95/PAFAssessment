package com.haijie.PAFAssessment.models;

import java.time.LocalDate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    public String transactionId;
    public LocalDate date;
    public String fromAccount;
    public String toAccount;
    public Float amount;
    public String toName;
    public String fromName;

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("transactionalId", this.getTransactionId())
                .add("date", this.getDate().toString())
                .add("from_account", this.getFromAccount())
                .add("to_account", this.getToAccount())
                .add("amount", this.getAmount())
                .build();
    }
}
