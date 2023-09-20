package com.banking.opeartion.service;

import com.banking.opeartion.entity.Account;
import com.banking.opeartion.entity.Transaction;
import com.banking.opeartion.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction>getTransactionById(Long id){
        Account account=new Account();
        account.setId(id);
        return transactionRepository.findByAccount(account);
    }

}
