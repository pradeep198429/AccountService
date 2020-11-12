package com.pradeep.accountenquiryservice.model;

import java.util.List;


public class AccountTransactionResponse {
    private String accountNumber;
    private String accountName;
    private String currency;
    private List<TransactionDTO> transactions;

    public AccountTransactionResponse() {
    }

    public AccountTransactionResponse(String accountNumber, String accountName, String currency, List<TransactionDTO> transactions) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.currency = currency;
        this.transactions = transactions;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
