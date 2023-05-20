package com.keelean.tech;

import com.keelean.com.Account;
import com.keelean.com.AccountManager;
import com.keelean.com.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountServiceEasyMock {

    private AccountManager mockAccountManager;

    @BeforeEach
    public void setUp(){
        mockAccountManager = createMock("mockAccountManager", AccountManager.class);
    }

    @Test
    public void testTransferOk(){
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        mockAccountManager.updateAccount(senderAccount);
        mockAccountManager.updateAccount(beneficiaryAccount);

        expect(mockAccountManager.findAccountForUser("1")).andReturn(senderAccount);
        expect(mockAccountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);

        replay(mockAccountManager);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

    @AfterEach
    public void destroy(){
        verify(mockAccountManager);
    }
}
