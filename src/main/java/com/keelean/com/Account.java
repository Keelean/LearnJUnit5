package com.keelean.com;

public class Account {
    private String accountId;
    private long balance;

    public String getAccountId() {
        return accountId;
    }

    public void credit(long amount) {
        this.balance += amount;
    }

    public long getBalance() {
        return balance;
    }

    public void debit(long amount) {
        this.balance -= amount;
    }

    public Account(String accountId, long initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }
}
