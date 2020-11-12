package com.pradeep.accountenquiryservice.service.impl;

import com.pradeep.accountenquiryservice.entity.Account;
import com.pradeep.accountenquiryservice.entity.AccountTransaction;
import com.pradeep.accountenquiryservice.model.AccountListResponse;
import com.pradeep.accountenquiryservice.model.AccountTransactionResponse;
import com.pradeep.accountenquiryservice.model.exception.InvalidRequestException;
import com.pradeep.accountenquiryservice.repository.AccountRepository;
import com.pradeep.accountenquiryservice.repository.AccountTransactionRepository;
import com.pradeep.accountenquiryservice.service.AccountEnquiryService;
import com.pradeep.accountenquiryservice.util.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountEnquiryServiceImpl implements AccountEnquiryService {

    private final AccountRepository accountRepository;
    private final AccountTransactionRepository accountTransactionRepository;
    private final Utility utility;

    public AccountEnquiryServiceImpl(AccountRepository accountRepository,
                                     AccountTransactionRepository accountTransactionRepository,
                                     Utility utility) {
        this.accountRepository = accountRepository;
        this.accountTransactionRepository = accountTransactionRepository;
        this.utility = utility;
    }

    @Override
    public List<AccountListResponse> getAccountsList(int userId) {
        Iterable<Account> accounts = accountRepository.findAllByUserId(userId);
        if(!accounts.iterator().hasNext()) {
            throw new InvalidRequestException(HttpStatus.BAD_REQUEST, "Invalid userId / UserId not found");
        }
        return utility.createResponse(accounts);
    }

    @Override
    public AccountTransactionResponse getAccountTransactions(int userId, String accountNumber) {
        Account account = accountRepository.findTopByUserIdAndAccountNumber(userId, accountNumber)
                .orElseThrow(() -> new InvalidRequestException(HttpStatus.BAD_REQUEST,
                        "User does not have account with account number " + accountNumber));
        Iterable<AccountTransaction> accountTransactions
                = accountTransactionRepository.findAllByAccountNumber(accountNumber);
        return utility.createResponse(account, accountTransactions);
    }
}
