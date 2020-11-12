package com.pradeep.accountenquiryservice.repository;

import com.pradeep.accountenquiryservice.entity.AccountTransaction;
import com.pradeep.accountenquiryservice.entity.AccountTransactionId;
import org.springframework.data.repository.CrudRepository;

public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, AccountTransactionId> {
    Iterable<AccountTransaction> findAllByAccountNumber(String accountNumber);
}
