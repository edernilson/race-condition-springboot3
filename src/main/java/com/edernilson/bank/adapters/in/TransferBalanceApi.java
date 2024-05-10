package com.edernilson.bank.adapters.in;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.bank.application.TransferBalanceUseCase;
import com.edernilson.bank.application.requests.PostTransferBalance;
import com.edernilson.bank.application.responses.GetAccountBalance;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/05/2024, quarta-feira
 */
@Tag(name = "Accounts", description = "Transfer balance between accounts")
@Validated
@RestController
@RequestMapping("/accounts")
public record TransferBalanceApi(TransferBalanceUseCase useCase) {

    @PostMapping("/transfer")
    public List<GetAccountBalance> transferBalance(@RequestBody @Valid PostTransferBalance postTransferBalance) {
        return useCase.transferBalance(postTransferBalance.idAccountOrigin(),
                postTransferBalance.idAccountDestiny(),
                postTransferBalance.amount()
        );
    }
}