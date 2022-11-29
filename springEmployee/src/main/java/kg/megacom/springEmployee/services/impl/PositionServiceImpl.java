package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Position;
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
    public Position save(Position position) {
        return positionRepository.save(position);
    }


    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
