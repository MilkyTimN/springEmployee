package kg.megacom.springEmployee.models.dtos;

import kg.megacom.springEmployee.models.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class AccountDto {

    Long id;
    String login;
    String password;
    Integer counter;
    AccountStatus accountStatus;
    Date addDate;
    Date updateDate;

}
