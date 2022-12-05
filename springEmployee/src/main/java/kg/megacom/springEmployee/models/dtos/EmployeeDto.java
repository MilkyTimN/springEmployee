package kg.megacom.springEmployee.models.dtos;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;
    String name;
    AccountDto account;
    PositionDto position;
}
