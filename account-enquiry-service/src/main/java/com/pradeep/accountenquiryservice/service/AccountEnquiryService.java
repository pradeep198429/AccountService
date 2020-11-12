package com.pradeep.accountenquiryservice.service;

import com.pradeep.accountenquiryservice.model.AccountListResponse;
import com.pradeep.accountenquiryservice.model.AccountTransactionResponse;

import java.util.List;

public interface AccountEnquiryService {
    List<AccountListResponse> getAccountsList(int userId);
    AccountTransactionResponse getAccountTransactions(int userId, String accountNumber) throws Exception;

}
