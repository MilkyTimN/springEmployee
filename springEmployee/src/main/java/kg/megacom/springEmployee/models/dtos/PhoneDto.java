package kg.megacom.springEmployee.models.dtos;

import kg.megacom.springEmployee.models.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDto {

    Long id;
    String phoneNumber;
    EmployeeDto employeeDto;
}
