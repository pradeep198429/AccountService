package com.pradeep.accountenquiryservice.controller;

import com.pradeep.accountenquiryservice.model.AccountListResponse;
import com.pradeep.accountenquiryservice.model.AccountTransactionResponse;
import com.pradeep.accountenquiryservice.service.AccountEnquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountEnquiryController {

    private final AccountEnquiryService accountEnquiryService;

    public AccountEnquiryController(AccountEnquiryService accountEnquiryService) {
        this.accountEnquiryService = accountEnquiryService;
    }

    @GetMapping
    public ResponseEntity<List<AccountListResponse>> getAccountsList(@RequestParam("userId") int userId) {
        return ResponseEntity.ok(accountEnquiryService.getAccountsList(userId));
    }

    @GetMapping("/transactions")
    public ResponseEntity<AccountTransactionResponse> getAccountTransactions(@RequestParam("userId") int userId,
                                                                                   @RequestParam("accountNumber") String accountNumber) throws Exception {
        return ResponseEntity.ok(accountEnquiryService.getAccountTransactions(userId, accountNumber));
    }

}
