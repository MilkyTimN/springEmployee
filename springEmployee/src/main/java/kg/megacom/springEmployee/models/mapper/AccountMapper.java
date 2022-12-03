package kg.megacom.springEmployee.models.mapper;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.dtos.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account, AccountDto>{

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

}
