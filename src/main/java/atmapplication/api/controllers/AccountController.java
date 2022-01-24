package atmapplication.api.controllers;

import atmapplication.api.dto.AccountsDto;
import atmapplication.business.abstracts.AccountService;
import atmapplication.entities.concretes.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
