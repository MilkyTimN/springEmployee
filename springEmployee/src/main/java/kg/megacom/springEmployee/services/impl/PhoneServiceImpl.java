package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Phone;
import kg.megacom.springEmployee.models.dtos.PhoneDto;
import kg.megacom.springEmployee.models.mapper.PhoneMapper;
import kg.megacom.springEmployee.repositories.PhoneRepository;
import kg.megacom.springEmployee.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public PhoneDto save(PhoneDto phoneDto) {
        return PhoneMapper.INSTANCE.toDto(phoneRepository.save(PhoneMapper.INSTANCE.toEntity(phoneDto)));
    }

    @Override
    public PhoneDto findById(Long id) {
        return PhoneMapper.INSTANCE.toDto(phoneRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found")));
    }

    @Override
    public List<PhoneDto> findAll() {
        return PhoneMapper.INSTANCE.toDtos(phoneRepository.findAll());
    }
}
