package kg.megacom.springEmployee.models.dtos;

import kg.megacom.springEmployee.models.enums.AccountStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {

    Long id;
    String login;
    String password;
    Integer counter;
    AccountStatus accountStatus;
    Date addDate;
    Date updateDate;

}
