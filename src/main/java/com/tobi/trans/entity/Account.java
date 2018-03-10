package com.tobi.trans.entity;

//import org.hibernate.annotations.ColumnDefault;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String pin;
    private String bank;
    private String number;
    private String email;
    private Double balance;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="account_transaction",joinColumns={@JoinColumn(name="number")},inverseJoinColumns={@JoinColumn(name="transactionId")})
    private List<Transaction> listOfTransactions;

    public Account(){

    }

    public Account(String name, String pin, String bank, String number, String email, Double balance) {
        this.name = name;
        this.pin = pin;
        this.bank = bank;
        this.number = number;
        this.email = email;
        this.balance = balance;
    }


//    @Column(nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public Double setBalance(Double balance) {
        return this.balance = balance;
    }

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListTransactions(List<Transaction> listTransactions) {
        this.listOfTransactions = listTransactions;
    }

    public boolean debitAccount(Double amount){
        if (this.getBalance() <= 0){
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public boolean creditAccount(Double amount){

        this.balance += amount;
        return true;
    }


}
