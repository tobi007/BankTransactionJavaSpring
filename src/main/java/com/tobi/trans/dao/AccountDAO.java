package com.tobi.trans.dao;

import com.tobi.trans.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
    Account findByNumber(String number);
}