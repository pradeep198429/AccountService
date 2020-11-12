package com.pradeep.accountenquiryservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "account_transactions")
@IdClass(AccountTransactionId.class)
public class AccountTransaction {
    @Id
    @Column(name = "transaction_id")
    private int transactionId;

    @Id
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "debit_amount")
    private Double debitAmount;
    @Column(name = "credit_amount")
    private Double creditAmount;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "transaction_narrative")
    private String transactionNarrative;

    public AccountTransaction() {
    }

    public AccountTransaction(int transactionId,
                              String accountNumber,
                              Double debitAmount,
                              Double creditAmount,
                              String transactionType,
                              Date transactionDate,
                              String transactionNarrative) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.transactionNarrative = transactionNarrative;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }
}
