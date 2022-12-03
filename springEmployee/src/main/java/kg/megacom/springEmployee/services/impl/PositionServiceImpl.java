package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Position;
import kg.megacom.springEmployee.models.dtos.PositionDto;
import kg.megacom.springEmployee.models.mapper.PositionMapper;
import kg.megacom.springEmployee.repositories.PositionRepository;
import kg.megacom.springEmployee.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public PositionDto save(PositionDto positionDto) {
        return PositionMapper.INSTANCE.toDto(positionRepository.save(PositionMapper.INSTANCE.toEntity(positionDto)));
    }


    @Override
    public PositionDto findById(Long id) {
        return PositionMapper.INSTANCE.toDto(positionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found")));
    }

    @Override
    public List<PositionDto> findAll() {
        return PositionMapper.INSTANCE.toDtos(positionRepository.findAll());
    }
}
