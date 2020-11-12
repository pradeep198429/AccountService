package com.pradeep.accountenquiryservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "currency")
    private String currency;
    @Column(name = "balance_date")
    private Date balanceDate;
    @Column(name = "account_type")
    private String accountType;

    public Account() {
    }

    public Account(String accountNumber, String accountName, int userId, String currency, Date balanceDate, String accountType) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.userId = userId;
        this.currency = currency;
        this.balanceDate = balanceDate;
        this.accountType = accountType;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
