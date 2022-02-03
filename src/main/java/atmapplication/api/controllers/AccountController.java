package atmapplication.api.controllers;

import atmapplication.api.dto.AccountsDto;
import atmapplication.api.dto.DepositDto;
import atmapplication.api.dto.WithdrawDto;
import atmapplication.business.abstracts.AccountService;
import atmapplication.entities.concretes.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        super();
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> accounts(@RequestBody AccountsDto accountsDto){
        return ResponseEntity.ok(accountService.accounts(accountsDto.getUserId(),accountsDto.getAccountType()));
    }

    @PutMapping("/withdraw")
    public ResponseEntity<Double> withdraw(@RequestBody WithdrawDto withdrawDto){
        return ResponseEntity.ok(accountService.withdraw(withdrawDto.getUserId(),withdrawDto.getAccountType(),withdrawDto.getWithdraw()));
    }

    @PutMapping("/deposit")
    public ResponseEntity<Double> deposit(@RequestBody DepositDto depositDto){
        return ResponseEntity.ok(accountService.deposit(depositDto.getUserId(),depositDto.getAccountType(),depositDto.getDeposit()));
    }

}
