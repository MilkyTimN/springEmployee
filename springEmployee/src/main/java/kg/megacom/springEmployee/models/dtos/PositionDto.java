package kg.megacom.springEmployee.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionDto {

    Long id;
    String definition;

}
