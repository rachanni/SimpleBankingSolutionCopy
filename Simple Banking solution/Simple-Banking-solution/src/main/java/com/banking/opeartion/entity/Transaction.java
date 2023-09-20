package com.banking.opeartion.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Date date;
    private  double amount;

    @ManyToOne
    @JsonBackReference
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }
}
