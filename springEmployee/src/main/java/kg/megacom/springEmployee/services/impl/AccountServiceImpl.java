package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.dtos.AccountDto;
import kg.megacom.springEmployee.models.enums.AccountStatus;
import kg.megacom.springEmployee.models.mapper.AccountMapper;
import kg.megacom.springEmployee.models.requests.AuthRequest;
import kg.megacom.springEmployee.models.responses.AuthResponse;
import kg.megacom.springEmployee.repositories.AccountRepository;
import kg.megacom.springEmployee.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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


    @Override
    public AuthResponse auth(AuthRequest authRequest) {
//        Account account = accountRepository.findByLogin(authRequest.getLogin());

        AccountDto accountDto = getByLogin(authRequest.getLogin());
        switch (accountDto.getAccountStatus()) {
            case DELETED:
                throw new RuntimeException("Account deleted");
            case BLOCKED:
                if (checkDate(accountDto.getUpdateDate())) {
                    accountDto.setCounter(0);
                    accountDto.setAccountStatus(AccountStatus.ACTIVE);
                    break;
                }
                throw new RuntimeException("Account blocked");
            case ACTIVE:
                break;
            default:
                throw new RuntimeException("Error with account status");
        }

        if (!accountDto.getPassword().equals(authRequest.getPassword())) {
            if (accountDto.getCounter()>=3) {
                accountDto.setAccountStatus(AccountStatus.BLOCKED);
                save(accountDto);
                throw new RuntimeException("Account blocked");
            }
            accountDto.setCounter(accountDto.getCounter()+1);
            save(accountDto);
            throw new RuntimeException("Incorrect password");
        }
        return null;
    }

    private boolean checkDate(Date updateDate) {
        Calendar checkDate = Calendar.getInstance();
        checkDate.setTime(updateDate);
        checkDate.add(Calendar.HOUR,1);
        return new Date().after(checkDate.getTime());


    }

    private AccountDto getByLogin(String login) {
        return AccountMapper.INSTANCE.toDto(accountRepository.findByLogin(login)
                .orElseThrow(()->new RuntimeException("Account not found")));
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