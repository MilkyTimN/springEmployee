package kg.megacom.springEmployee.models.dtos;

import kg.megacom.springEmployee.models.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhoneDto {

    Long id;
    String phoneNumber;
    EmployeeDto employeeDto;
}
