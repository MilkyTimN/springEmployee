package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public Account saveAccount(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping("/get/{id}")
    public Account getAccount(@PathVariable("id")Long id){
        return accountService.findById(id);
    }

    @GetMapping("/get")
    public List<Account>getAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/login/{login}/{password}")
    public Account logIn(@PathVariable("login") String login,@PathVariable("password") String password ) {
        return accountService.findByLoginAndPassword(login, password);
    }
}
