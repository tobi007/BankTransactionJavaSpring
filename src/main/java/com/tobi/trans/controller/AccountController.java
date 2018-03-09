package com.tobi.trans.controller;

import java.util.ArrayList;
import java.util.List;

import com.tobi.trans.dao.AccountDAO;
import com.tobi.trans.entity.Account;
import com.tobi.trans.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tobi.trans.model.TransferRequest;
import com.tobi.trans.service.TransactionService;

import javax.validation.Valid;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api/") // This means URL's start with /demo (after Application path)
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/account/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public Account createAccount(@Valid @RequestBody Account account) {

//        List<Transaction> transactions = new ArrayList();
//
//        Transaction trans1 = new Transaction(
//                "MANUAL_TRANSFER",
//                "DEBIT_TRANSFER",
//                null,
//                "Yetty Bola",
//                account.getNumber(),
//                account.getName(),
//                1000000.0
//        );
//
//        Transaction trans2 = new Transaction(
//                "MANUAL_TRANSFER",
//                "DEBIT_TRANSFER",
//                null,
//                " LG MOOTORS",
//                account.getNumber(),
//                account.getName(),
//                5000.0
//        );
//
//        Transaction trans3 = new Transaction(
//                "MANUAL_TRANSFER",
//                "DEBIT_TRANSFER",
//                null,
//                "Noah RObotics",
//                account.getNumber(),
//                account.getName(),
//                10000.0
//        );
//
//        transactions.add(trans1);
//        transactions.add(trans2);
//        transactions.add(trans3);
//
//
//        account.setListTransactions(transactions);
//
//        //return account;
        return accountDAO.save(account);
    }

    public void allTransaction(){

    }
}
