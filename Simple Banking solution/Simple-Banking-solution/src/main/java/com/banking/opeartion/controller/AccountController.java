package com.banking.opeartion.controller;


import com.banking.opeartion.entity.Account;
import com.banking.opeartion.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {



    //controller is meant to access business logic
    //business logic is in Service class
    //user access controller or user hit controller and controller will hit Service class
    //create AccountService object
    @Autowired
    private AccountService accountService;



    @PostMapping("/createAccount")
    public Account creatAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long id, @RequestParam Double amount) {
        Account updatedAccount = accountService.deposit(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long id, @RequestParam Double amount) {
        Account updatedAccount = accountService.withdraw(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }



}
