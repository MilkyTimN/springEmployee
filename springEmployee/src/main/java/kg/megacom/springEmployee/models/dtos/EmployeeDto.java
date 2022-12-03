package kg.megacom.springEmployee.models.dtos;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class EmployeeDto {

    Long id;
    String name;
    AccountDto account;
    PositionDto position;
}
