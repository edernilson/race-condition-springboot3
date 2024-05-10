package com.edernilson.bank.application.requests;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 10/05/2024, sexta-feira
 */
public record PostTransferBalance(
        long idAccountOrigin,
        long idAccountDestiny,
        double amount) {
}