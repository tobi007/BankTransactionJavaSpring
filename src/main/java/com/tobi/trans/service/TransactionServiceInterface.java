package com.tobi.trans.service;

import com.tobi.trans.entity.Account;
import com.tobi.trans.model.TransferRequest;
import com.tobi.trans.model.TransferResponse;

import java.util.List;

public interface TransactionServiceInterface {

    TransferResponse process(TransferRequest request);
}
