package com.banking.opeartion.controller;


import com.banking.opeartion.entity.Account;
import com.banking.opeartion.entity.Transaction;
import com.banking.opeartion.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account/{id}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable Long id) {
        List<Transaction> transactions = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transactions);
    }
}
