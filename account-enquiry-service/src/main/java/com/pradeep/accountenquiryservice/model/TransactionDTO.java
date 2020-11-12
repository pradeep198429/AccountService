package com.pradeep.accountenquiryservice.model;

import com.pradeep.accountenquiryservice.entity.AccountTransaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDTO {
    private String date;
    private String type;
    private Double debitAmount;
    private Double creditAmount;
    private String transactionNarrative;

    public TransactionDTO() {
    }

    public TransactionDTO(Date date,
                          String type,
                          Double debitAmount,
                          Double creditAmount,
                          String transactionNarrative) {
    	
    	SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
        this.date =dt1.format(date); 
        this.type = type;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.transactionNarrative = transactionNarrative;
    }

    public static TransactionDTO from(AccountTransaction accountTransaction) {

       return new TransactionDTO(accountTransaction.getTransactionDate(),
                accountTransaction.getTransactionType(),
                accountTransaction.getDebitAmount(),
                accountTransaction.getCreditAmount(),
                accountTransaction.getTransactionNarrative());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }
}
