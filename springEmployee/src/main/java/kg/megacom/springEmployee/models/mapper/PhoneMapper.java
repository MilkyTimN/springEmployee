package kg.megacom.springEmployee.models.mapper;

import kg.megacom.springEmployee.models.Phone;
import kg.megacom.springEmployee.models.dtos.PhoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper extends BaseMapper<Phone, PhoneDto>{

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);
}
