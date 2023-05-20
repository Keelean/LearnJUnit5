package com.keelean.tech;

import com.keelean.com.Account;
import com.keelean.com.AccountManager;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManager {
    private Map<String, Account> accounts  = new HashMap<>();

    public void addAccount(String userId, Account account) {
        /*if(accounts.containsKey(userId))
            return;*/
        accounts.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
    }
}
