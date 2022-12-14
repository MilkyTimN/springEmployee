package kg.megacom.springEmployee.services.impl;

import kg.megacom.springEmployee.models.Account;
import kg.megacom.springEmployee.models.Employee;
import kg.megacom.springEmployee.models.Position;
import kg.megacom.springEmployee.models.dtos.EmployeeDto;
import kg.megacom.springEmployee.models.enums.AccountStatus;
import kg.megacom.springEmployee.models.mapper.EmployeeMapper;
import kg.megacom.springEmployee.repositories.AccountRepository;
import kg.megacom.springEmployee.repositories.EmployeeRepository;
import kg.megacom.springEmployee.repositories.PositionRepository;
import kg.megacom.springEmployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AccountRepository accountRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AccountRepository accountRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.accountRepository = accountRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        return EmployeeMapper.INSTANCE.toDto(employeeRepository.save(EmployeeMapper.INSTANCE.toEntity(employeeDto)));
    }

    @Override
    public EmployeeDto findById(Long id) {
        return EmployeeMapper.INSTANCE.toDto(employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found")));
    }

    @Override
    public List<EmployeeDto> findAll() {
        return EmployeeMapper.INSTANCE.toDtos(employeeRepository.findAll());
    }
}
