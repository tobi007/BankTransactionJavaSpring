package com.tobi.trans.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String transactionId;
    private String transactionType;
    private String transactionMode;
    private String sourceAccountNumber = null;
    private String sourceFullName;
    private String destinationAccount;
    private String destinationFullName;
    private Double amount;

    public Transaction(){

    }

    public Transaction(String transactionType, String transactionMode, String sourceAccountNumber, String sourceFullName,
                       String destinationAccount, String destinationFullName, Double amount  ) {
        super();
        this.transactionType = transactionType;
        this.transactionMode = transactionMode;
        this.sourceAccountNumber = sourceAccountNumber;
        this.sourceFullName = sourceFullName;
        this.destinationAccount = destinationAccount;
        this.destinationFullName = destinationFullName;
        this.amount = amount;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getSourceFullName() {
        return sourceFullName;
    }

    public void setSourceFullName(String sourceFullName) {
        this.sourceFullName = sourceFullName;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getDestinationFullName() {
        return destinationFullName;
    }

    public void setDestinationFullName(String destinationFullName) {
        this.destinationFullName = destinationFullName;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
