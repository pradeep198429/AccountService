package com.pradeep.accountenquiryservice.util;

import com.pradeep.accountenquiryservice.entity.Account;
import com.pradeep.accountenquiryservice.entity.AccountTransaction;
import com.pradeep.accountenquiryservice.model.AccountListResponse;
import com.pradeep.accountenquiryservice.model.AccountTransactionResponse;
import com.pradeep.accountenquiryservice.model.TransactionDTO;
import com.pradeep.accountenquiryservice.repository.AccountTransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class Utility {
    private final AccountTransactionRepository accountTransactionRepository;

    public Utility(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    public AccountTransactionResponse createResponse(Account account,
                                                     Iterable<AccountTransaction> accountTransactions) {

        return new AccountTransactionResponse(account.getAccountNumber(),
                account.getAccountName(),
                account.getCurrency(),
                StreamSupport.stream(accountTransactions.spliterator(), false)
                        .map(TransactionDTO::from).collect(Collectors.toList()));
    }

    public List<AccountListResponse> createResponse(Iterable<Account> accounts) {
        return StreamSupport.stream(accounts.spliterator(), false)
                .map(account -> AccountListResponse.from(account, getBalance(account.getAccountNumber())))
                .collect(Collectors.toList());
    }

    private double getBalance(String accountNumber) {
        double totalSum = 0;
        for (AccountTransaction accountTransaction :
                accountTransactionRepository.findAllByAccountNumber(accountNumber)) {
            if ("Credit".equals(accountTransaction.getTransactionType())) {
                totalSum += accountTransaction.getCreditAmount();
            } else {
                totalSum -= accountTransaction.getDebitAmount();
            }
        }

        return totalSum;
    }
}
