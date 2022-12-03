package kg.megacom.springEmployee.models.mapper;

import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.models.dtos.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper extends BaseMapper <Employee, EmployeeDto>{

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


}
