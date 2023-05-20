package com.keelean.com;

public interface AccountManager {

    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
