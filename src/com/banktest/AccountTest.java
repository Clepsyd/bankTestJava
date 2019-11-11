package com.banktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {

    private Account account;

    @BeforeEach
    void initAccount() {
        account = new Account();
    }

    @Test
    @DisplayName("account should start with a Balance of 0")
    void getBalance() {
        assertEquals(account.getBalance(), 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {25.25, 500.56, 75})
    @DisplayName("deposit() should add to the balance")
    void deposit(double amount) {
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

    @ParameterizedTest
    @ValueSource(doubles = {-1, -10.56, -40})
    @DisplayName("deposit raises an error when passed a negative number")
    void depositRaisesErrorWithNegative(double negativeAmount) {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            account.deposit(negativeAmount);
        });
        assertEquals("Cannot deposit a negative sum!", exception.getMessage());
    }

}