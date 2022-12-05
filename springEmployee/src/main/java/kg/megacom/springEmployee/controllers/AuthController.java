package kg.megacom.springEmployee.controllers;

import kg.megacom.springEmployee.models.requests.AuthRequest;
import kg.megacom.springEmployee.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AccountService accountService;

    @Autowired
    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<?> auth (@RequestBody AuthRequest authRequest){
        try {
            return ResponseEntity.ok(accountService.auth(authRequest));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
