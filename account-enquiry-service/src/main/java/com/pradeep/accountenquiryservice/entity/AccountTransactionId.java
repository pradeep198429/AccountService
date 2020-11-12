package com.pradeep.accountenquiryservice.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class AccountTransactionId implements Serializable {
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "account_number")
    private String accountNumber;
}
