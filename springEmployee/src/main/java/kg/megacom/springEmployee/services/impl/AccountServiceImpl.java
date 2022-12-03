package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.dtos.AccountDto;
import kg.megacom.springEmployee.models.mapper.AccountMapper;
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
    public AccountDto save(AccountDto accountDto) {

        return AccountMapper.INSTANCE.toDto(accountRepository.save(AccountMapper.INSTANCE.toEntity(accountDto)));
    }

    //TODO
    @Override
    public String auth(String login, String password) {
        Account account = accountRepository.findByLogin(login);
        if (account.getLogin().equals(null)) {
            return "Account with login: " + login + " not found";
        } else {
            if (account.getPassword().equals(password)) {
                return "Authorization went successfully";
            }   else {
                return "Wrong password";
            }
        }
    }

    @Override
    public AccountDto findById(Long id) {
        return AccountMapper.INSTANCE.toDto(accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    @Override
    public List<AccountDto> findAll() {
        return AccountMapper.INSTANCE.toDtos(accountRepository.findAll());
    }


}