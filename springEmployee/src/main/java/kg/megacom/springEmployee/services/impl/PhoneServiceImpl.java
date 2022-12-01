package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Phone;
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
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
    }

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
}
