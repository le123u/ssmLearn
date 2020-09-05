package com.neusoft.dao;

import com.neusoft.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {

    List<Account> findAll() throws SQLException;

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
