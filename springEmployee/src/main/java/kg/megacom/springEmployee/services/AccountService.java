package kg.megacom.springEmployee.services;

import kg.megacom.springEmployee.models.Account;

public interface AccountService extends BaseService<Account>{

    Account findByLoginAndPassword(String login, String password);


}
