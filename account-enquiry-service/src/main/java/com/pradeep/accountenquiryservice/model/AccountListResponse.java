package com.pradeep.accountenquiryservice.model;

import com.pradeep.accountenquiryservice.entity.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AccountListResponse {
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String balanceDate;
    private String currency;
    private double openingBalance;

    public AccountListResponse() {
    }

    public AccountListResponse(String accountNumber, String accountName, String accountType, Date balanceDate, String currency, double openingBalance) {
    	SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
    	
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate=dt1.format(balanceDate);	  
        this.currency = currency;
        this.openingBalance = openingBalance;
    }

    public static AccountListResponse from(Account account, double balance) {
    	
        return new AccountListResponse(account.getAccountNumber(),
                account.getAccountName(),
                account.getAccountType(),
                account.getBalanceDate(),
                account.getCurrency(),
                balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }
}
