package kg.megacom.springEmployee.services;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.dtos.AccountDto;
import kg.megacom.springEmployee.models.requests.AuthRequest;
import kg.megacom.springEmployee.models.responses.AuthResponse;

public interface AccountService extends BaseService<AccountDto>{


    AuthResponse auth(AuthRequest authRequest);
}
