package com.pradeep.accountenquiryservice.service.impl;

import com.pradeep.accountenquiryservice.entity.Account;
import com.pradeep.accountenquiryservice.entity.AccountTransaction;
import com.pradeep.accountenquiryservice.model.AccountListResponse;
import com.pradeep.accountenquiryservice.model.AccountTransactionResponse;
import com.pradeep.accountenquiryservice.model.exception.InvalidRequestException;
import com.pradeep.accountenquiryservice.repository.AccountRepository;
import com.pradeep.accountenquiryservice.repository.AccountTransactionRepository;
import com.pradeep.accountenquiryservice.util.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
class AccountEnquiryServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountTransactionRepository accountTransactionRepository;

    private AccountEnquiryServiceImpl accountEnquiryService;

    @BeforeAll
    void setUp() {
        accountEnquiryService = new AccountEnquiryServiceImpl(accountRepository,
                accountTransactionRepository,
                new Utility(accountTransactionRepository));

        Account savingsAccount = new Account("1234",
                "Savings",
                1,
                "INR",
                Date.valueOf("2019-09-19"),
                "Savings");

        Account currentAccount =  new Account("5678",
                "Current",
                1,
                "INR",
                    Date.valueOf("2019-09-19"),
                "Current");

        Mockito.when(accountRepository.findAllByUserId(ArgumentMatchers.anyInt()))
                .thenReturn(List.of(savingsAccount, currentAccount));

        Mockito.when(accountTransactionRepository.findAllByAccountNumber("1234"))
                .thenReturn(List.of(
                        new AccountTransaction(1, "1234", null, 5000.00,
                                "Credit",  Date.valueOf("2019-09-01"), null),
                        new AccountTransaction(2, "1234", 2000.00, null,
                                "Debit", Date.valueOf("2019-09-01"), null)
                        )
                );

        Mockito.when(accountTransactionRepository.findAllByAccountNumber("5678"))
                .thenReturn(List.of(
                        new AccountTransaction(2, "5678", null, 10000.00,
                                "Credit", Date.valueOf("2019-09-01"), null),
                        new AccountTransaction(2, "5678", null, 2000.00,
                                "Credit", Date.valueOf("2019-09-01"), null)
                        )
                );

        Mockito.when(accountRepository.findTopByUserIdAndAccountNumber(ArgumentMatchers.anyInt(),
                ArgumentMatchers.eq("1234")))
                .thenReturn(of(savingsAccount));

        Mockito.when(accountRepository.findTopByUserIdAndAccountNumber(ArgumentMatchers.anyInt(),
                ArgumentMatchers.eq("5678")))
                .thenReturn(of(currentAccount));
    }

    @Test
    void getAccountsList() {
        List<AccountListResponse> accountsList = accountEnquiryService.getAccountsList(1);

        Assertions.assertEquals(2, accountsList.size());

        Assertions.assertEquals("1234", accountsList.get(0).getAccountNumber());
        Assertions.assertEquals("Savings", accountsList.get(0).getAccountName());
        Assertions.assertEquals(3000.00, accountsList.get(0).getOpeningBalance());

        Assertions.assertEquals("5678", accountsList.get(1).getAccountNumber());
        Assertions.assertEquals("Current", accountsList.get(1).getAccountName());
        Assertions.assertEquals(12000.00, accountsList.get(1).getOpeningBalance());
    }

    @Test
    void getAccountTransactions() {
        AccountTransactionResponse accountTransactions = accountEnquiryService.getAccountTransactions(1, "1234");

        Assertions.assertEquals("Savings", accountTransactions.getAccountName());
        Assertions.assertEquals("1234", accountTransactions.getAccountNumber());
        Assertions.assertEquals("INR", accountTransactions.getCurrency());

        Assertions.assertEquals(2, accountTransactions.getTransactions().size());

        Assertions.assertEquals("Credit", accountTransactions.getTransactions().get(0).getType());
        Assertions.assertEquals("Debit", accountTransactions.getTransactions().get(1).getType());

        Assertions.assertEquals(5000.00, accountTransactions.getTransactions().get(0).getCreditAmount());
        Assertions.assertEquals(2000.00, accountTransactions.getTransactions().get(1).getDebitAmount());

    }

    @Test
    void getAccountTransactions_throwsException() {
        Mockito.when(accountRepository.findTopByUserIdAndAccountNumber(ArgumentMatchers.anyInt(), ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(InvalidRequestException.class, () -> {
            accountEnquiryService.getAccountTransactions(1,"12345667");
        });
    }
}