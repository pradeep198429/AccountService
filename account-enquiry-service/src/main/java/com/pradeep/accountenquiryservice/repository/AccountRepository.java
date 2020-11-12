package com.pradeep.accountenquiryservice.repository;

import com.pradeep.accountenquiryservice.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {
    Iterable<Account> findAllByUserId(int userId);
    Optional<Account> findTopByUserIdAndAccountNumber(int userId, String accountNumber);
}
