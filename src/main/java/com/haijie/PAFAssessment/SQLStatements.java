package com.haijie.PAFAssessment;

public class SQLStatements {
    public static final String selectAllSQL="select * from accounts";
    public static final String findByAccIdSQL="select * from accounts where account_id= ?";
    public static final String withdrawByAccId="update accounts set balance=balance-? where account_id=?";
    public static final String depositByAccId="update accounts set balance=balance+? where account_id=?";
}
