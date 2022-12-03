package kg.megacom.springEmployee.models.mapper;

import kg.megacom.springEmployee.models.Position;
import kg.megacom.springEmployee.models.dtos.PositionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PositionMapper extends BaseMapper<Position, PositionDto>{

    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

}
