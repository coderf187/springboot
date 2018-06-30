package com.example.mybatis.service;

import com.example.mybatis.entity.Account;
import com.example.mybatis.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public int add(Account account) {
        return accountMapper.add(account);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> listAccount() {
        return accountMapper.listAccount();
    }
}
