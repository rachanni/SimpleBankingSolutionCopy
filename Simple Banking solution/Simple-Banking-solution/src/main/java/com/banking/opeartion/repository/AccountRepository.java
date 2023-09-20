package com.banking.opeartion.repository;

import com.banking.opeartion.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
