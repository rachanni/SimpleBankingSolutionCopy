package com.banking.opeartion.service;


import com.banking.opeartion.entity.Account;
import com.banking.opeartion.entity.Transaction;
import com.banking.opeartion.exceptions.InsufficientFundsException;
import com.banking.opeartion.repository.AccountRepository;
import com.banking.opeartion.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;


import javax.naming.InsufficientResourcesException;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountService {


    @Autowired
    //created object of AccountRepository
    //this object can access method present in CrudRepository like findById(), save()
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    //return Account object name , id, balance
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }


    //finding account by id
    //we are not writing logic for how to find account we are simply using findById() method
    //and this method is accessible to AccountRepository object
    public Account getAccount(Long id){

            return accountRepository.findById(id)
                    .orElseThrow(()->new EntityNotFoundException("Account not found!")) ;
        }





    public Account deposit(Long id, Double amount){
        Account account=getAccount(id);
        Transaction transaction=new Transaction();
        transaction.setDate(new Date());
        transaction.setAmount(amount);
        transaction.setAccount(account); // setAccount() Transaction
        account.getTransactions().add(transaction); // getTransactions() Account
        account.setBalance(account.getBalance()+amount);
        return accountRepository.save(account);


    }

    public Account withdraw(Long id,double amount){
        Account account=getAccount(id);

        if(account.getBalance()<amount){
            throw new InsufficientFundsException("Insufficient fund!");
        }
        Transaction transaction=new Transaction();
        transaction.setDate(new Date());
        transaction.setAmount(-amount);
        transaction.setAccount(account);
        account.getTransactions().add(transaction);
        account.setBalance(account.getBalance()-amount);
        return accountRepository.save(account);
        }
    }



