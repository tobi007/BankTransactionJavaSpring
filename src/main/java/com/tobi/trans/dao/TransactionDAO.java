package com.tobi.trans.dao;

import com.tobi.trans.entity.Account;
import com.tobi.trans.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long> {

}