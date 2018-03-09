package com.tobi.trans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tobi.trans.entity.Account;
import com.tobi.trans.entity.Transaction;
import com.tobi.trans.model.TransferResponse;
import com.tobi.trans.model.TransferRequest;
import com.tobi.trans.service.TransactionService;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api/") // This means URL's start with /demo (after Application path)
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST, headers = "Accept=application/json")
    public TransferResponse transfer(@RequestBody TransferRequest request){
        return transactionService.process(request);
    }

    @RequestMapping(value = "/transaction/all", method = RequestMethod.POST, headers = "Accept=application/json")
    public TransferResponse allTransaction(@RequestBody TransferRequest request){
        return transactionService.getAllTransactions();
    }
}
