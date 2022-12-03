package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.dtos.AccountDto;
import kg.megacom.springEmployee.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> saveAccount(@RequestBody AccountDto accountDto){
        try{
            return ResponseEntity.ok(accountService.save(accountDto));
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAccount(@PathVariable("id")Long id){
        try{
            return ResponseEntity.ok(accountService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

//    @GetMapping("/get")
//    public List<Account>getAllAccounts(){
//        return accountService.findAll();
//    }

}
