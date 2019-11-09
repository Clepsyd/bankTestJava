package com.banktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account = new Account();

    @Test
    @DisplayName("account should start with a Balance of 0")
    void getBalance() {
        assertEquals(account.getBalance(), 0);
    }

    @Test
    @DisplayName("deposit() should add to the balance")
    void deposit() {
        account.deposit(100);
        assertEquals(account.getBalance(), 100);
    }

    @Test
    @DisplayName("withdraw() should substract from the balance")
    void withdraw() {
        account.deposit(100);
        account.withdraw(50);
        assertEquals(account.getBalance(), 50);
    }
}