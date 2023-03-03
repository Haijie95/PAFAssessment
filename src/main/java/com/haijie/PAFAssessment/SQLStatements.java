package com.haijie.PAFAssessment;

public class SQLStatements {
    public static final String selectAllSQL="select * from accounts";
    public static final String findByAccIdSQL="select * from accounts where account_id= ?";
    public static final String updateByAccId="update accounts set name=?,balance=? where account_id=?";
}
