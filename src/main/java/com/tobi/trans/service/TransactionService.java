package com.tobi.trans.service;

import com.tobi.trans.entity.Account;
import com.tobi.trans.entity.Transaction;
import com.tobi.trans.model.TransferRequest;
import com.tobi.trans.model.TransferResponse;
import com.tobi.trans.model.TransferType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tobi.trans.dao.AccountDAO;
import com.tobi.trans.dao.TransactionDAO;

import java.util.List;

@Service
public class TransactionService implements TransactionServiceInterface {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transationDAO;

    private TransferResponse response;

    @Override
    @Transactional
    public TransferResponse process(TransferRequest request) {

        try {
            if(TransferType.valueOf(request.getTransferType()) == TransferType.MANUAL_TRANSFER){
                return manualTransfer(request);
            }
            else if (TransferType.valueOf(request.getTransferType()) == TransferType.ONLINE_TRANSFER) {
                return onlineTransfer(request);
            }
        } catch (IllegalArgumentException ex) {
            response = new TransferResponse(false, "500", "Transfer error, please use the required medium");
            return response;
        }
        response = new TransferResponse(false, "500", "Transfer error");
        return response;
    }

    private TransferResponse manualTransfer(TransferRequest request){
        Account account = accountDAO.findByNumber(request.getDestinationAccountNumber());

        if (account != null && account.getName().compareTo(request.getDestinationFullName()) == 0){
            if(account.debitAccount(request.getAmount())){

                Transaction trans1 = new Transaction(
                    "MANUAL_TRANSFER",
                    "DEBIT_TRANSFER",
                    null,
                    request.getSourceFullName(),
                     request.getDestinationAccountNumber(),
                     request.getDestinationFullName(),
                    request.getAmount()
                );

                account.getListOfTransactions().add(trans1);

                accountDAO.save(account);

                response = new TransferResponse(true, "200", "Transfer was done successfully");
                response.getData().add(account);
                return response;
            }else {
                response = new TransferResponse(false, "500", "Error processing transfer");
                return response;
            }
        }else {

            response = new TransferResponse(false, "500", "Receiver details not correct");
            return response;
        }
    }

    private TransferResponse onlineTransfer(TransferRequest request){
        Account accountFrom = accountDAO.findByNumber(request.getSourceAccountNumber());
        Account accountTo = accountDAO.findByNumber(request.getDestinationAccountNumber());

        if (accountFrom != null && accountFrom.getNumber().compareTo(request.getSourceAccountNumber()) == 0){
            if (accountTo != null && accountTo.getNumber().compareTo(request.getDestinationAccountNumber()) == 0){
                if (accountFrom.creditAccount(request.getAmount()) && accountTo.debitAccount(request.getAmount())){
                    Transaction transFrom = new Transaction(
                            "ONLINE_TRANSFER",
                            "CREDIT_TRANSFER",
                            request.getSourceAccountNumber(),
                            request.getSourceFullName(),
                            request.getDestinationAccountNumber(),
                            request.getDestinationFullName(),
                            request.getAmount()
                    );
                    accountFrom.getListOfTransactions().add(transFrom);

                    Transaction transTo = new Transaction(
                            "ONLINE_TRANSFER",
                            "DEBIT_TRANSFER",
                            request.getSourceAccountNumber(),
                            request.getSourceFullName(),
                            request.getDestinationAccountNumber(),
                            request.getDestinationFullName(),
                            request.getAmount()
                    );
                    accountTo.getListOfTransactions().add(transTo);

                    accountDAO.save(accountFrom);
                    accountDAO.save(accountTo);

                    response = new TransferResponse(true, "200", "transfer was done successfully");
                    return response;



                } else {
                    response = new TransferResponse(false, "500", "Insufficient Balance");
                    return response;
                }
            }else {
                response = new TransferResponse(false, "500", "Receiver details not correct");
                return response;
            }
        }else {
            response = new TransferResponse(false, "500", "Sender details not correct");
            return response;
        }
    }

    public TransferResponse getAllTransactions(){
        response = new TransferResponse(false, "500", "Sender details not correct");
        response.getData().add(transationDAO.findAll());
        return response;
    }

}
