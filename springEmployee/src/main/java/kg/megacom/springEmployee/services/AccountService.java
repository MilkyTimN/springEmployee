package kg.megacom.springEmployee.services;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.dtos.AccountDto;

public interface AccountService extends BaseService<AccountDto>{


    String auth(String login, String password);
}
