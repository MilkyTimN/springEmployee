package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.repositories.AccountRepository;
import kg.megacom.springEmployee.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Account save(Account account) {
        account.setCounter(0);
        return accountRepository.save(account);
    }



    @Override
    public Account findByLoginAndPassword(String login, String password) {
        Integer counter;
        Account accountTemp = accountRepository.findByLoginAndPassword(login);
        if (accountTemp.getLogin().equals(null)){
            throw new RuntimeException("Account not found");
        } else if (accountTemp.getPassword().equals(password)){
            return accountTemp;
        } else {
            accountRepository.updateCounter();
            counter = accountRepository.checkCounter(login);
            if (counter > 3) {

                throw new RuntimeException("Blocked");
            }

            throw new RuntimeException("Wrong password");

        }

    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }


}