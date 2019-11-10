package com.banktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {

    private Account account = new Account();

    @Test
    @DisplayName("account should start with a Balance of 0")
    void getBalance() {
        assertEquals(account.getBalance(), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 50, 75})
    @DisplayName("deposit() should add to the balance")
    void deposit(int amount) {
        account.deposit(amount);
        assertEquals(account.getBalance(), amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 50, 75})
    @DisplayName("withdraw() should subtract from the balance")
    void withdraw(int amount) {
        account.deposit(100);
        account.withdraw(amount);
        assertEquals(account.getBalance(), 100 - amount);
    }

}