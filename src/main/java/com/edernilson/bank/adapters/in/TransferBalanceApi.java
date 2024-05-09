package com.edernilson.bank.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.bank.application.TransferBalanceUseCase;
import com.edernilson.bank.application.responses.GetAccountBalance;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/05/2024, quarta-feira
 */
//@Tag(name = "Accounts", description = "Transfer balance between accounts")
@RestController
@RequestMapping("/accounts")
public record TransferBalanceApi(TransferBalanceUseCase useCase) {

    @PostMapping("/transfer/{idAccountOrigin}/{idAccountDestiny}/{amount}")
    public List<GetAccountBalance> transferBalance(@PathVariable("idAccountOrigin") long idAccountOrigin,
                                                   @PathVariable("idAccountDestiny") long idAccountDestiny,
                                                   @PathVariable("amount") double amount) {
        return useCase.transferBalance(idAccountOrigin, idAccountDestiny, amount);
    }
}